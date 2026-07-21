import pandas as pd
import numpy as np


def calculate_credit_metrics(df: pd.DataFrame, requested_loan: float):
    """
    Expected columns:
        Revenue
        Assets
        Liabilities
        Contingents
        Limit
        Utilization

    Utilization should be the actual utilized amount (not %).
    """

    df = df.copy()

    first = df.iloc[0]
    latest = df.iloc[-1]

    metrics = {}

    # ---------------------------------------------------------
    # Latest values
    # ---------------------------------------------------------

    metrics["requested_loan"] = requested_loan

    metrics["latest_revenue"] = float(latest["Revenue"])
    metrics["latest_assets"] = float(latest["Assets"])
    metrics["latest_liabilities"] = float(latest["Liabilities"])
    metrics["latest_contingents"] = float(latest["Contingents"])
    metrics["latest_limit"] = float(latest["Limit"])
    metrics["latest_utilized"] = float(latest["Utilization"])

    # ---------------------------------------------------------
    # Growth over 12 months
    # ---------------------------------------------------------

    def growth(start, end):
        if start == 0:
            return 0
        return ((end - start) / start) * 100

    metrics["revenue_growth_pct"] = growth(
        first["Revenue"],
        latest["Revenue"]
    )

    metrics["asset_growth_pct"] = growth(
        first["Assets"],
        latest["Assets"]
    )

    metrics["liability_growth_pct"] = growth(
        first["Liabilities"],
        latest["Liabilities"]
    )

    metrics["contingent_growth_pct"] = growth(
        first["Contingents"],
        latest["Contingents"]
    )

    # ---------------------------------------------------------
    # Utilization %
    # ---------------------------------------------------------

    df["UtilizationPct"] = (
        df["Utilization"] / df["Limit"] * 100
    )

    metrics["avg_utilization_pct"] = float(
        df["UtilizationPct"].mean()
    )

    metrics["max_utilization_pct"] = float(
        df["UtilizationPct"].max()
    )

    metrics["min_utilization_pct"] = float(
        df["UtilizationPct"].min()
    )

    metrics["months_above_90_utilization"] = int(
        (df["UtilizationPct"] > 90).sum()
    )

    metrics["months_above_80_utilization"] = int(
        (df["UtilizationPct"] > 80).sum()
    )

    # ---------------------------------------------------------
    # Available limit
    # ---------------------------------------------------------

    metrics["available_limit"] = (
        latest["Limit"] - latest["Utilization"]
    )

    metrics["unused_limit_pct"] = (
        metrics["available_limit"] /
        latest["Limit"] * 100
    )

    # ---------------------------------------------------------
    # Ratios
    # ---------------------------------------------------------

    metrics["debt_asset_ratio"] = (
        latest["Liabilities"] /
        latest["Assets"]
    )

    metrics["contingent_asset_ratio"] = (
        latest["Contingents"] /
        latest["Assets"]
    )

    metrics["request_to_assets_pct"] = (
        requested_loan /
        latest["Assets"] * 100
    )

    metrics["request_to_revenue_pct"] = (
        requested_loan /
        latest["Revenue"] * 100
    )

    metrics["request_to_limit_pct"] = (
        requested_loan /
        latest["Limit"] * 100
    )

    metrics["request_to_available_limit_pct"] = (
        requested_loan /
        metrics["available_limit"] * 100
        if metrics["available_limit"] > 0
        else 999
    )

    # ---------------------------------------------------------
    # Revenue Stability
    # ---------------------------------------------------------

    revenue_mean = df["Revenue"].mean()
    revenue_std = df["Revenue"].std()

    metrics["revenue_stddev"] = float(revenue_std)

    metrics["revenue_cv_pct"] = (
        revenue_std /
        revenue_mean * 100
        if revenue_mean != 0
        else 0
    )

    # ---------------------------------------------------------
    # Utilization Stability
    # ---------------------------------------------------------

    util_mean = df["UtilizationPct"].mean()
    util_std = df["UtilizationPct"].std()

    metrics["utilization_stddev"] = float(util_std)

    metrics["utilization_cv_pct"] = (
        util_std /
        util_mean * 100
        if util_mean != 0
        else 0
    )

    # ---------------------------------------------------------
    # Asset Stability
    # ---------------------------------------------------------

    asset_mean = df["Assets"].mean()
    asset_std = df["Assets"].std()

    metrics["asset_cv_pct"] = (
        asset_std /
        asset_mean * 100
        if asset_mean != 0
        else 0
    )

    # ---------------------------------------------------------
    # Liability Stability
    # ---------------------------------------------------------

    liability_mean = df["Liabilities"].mean()
    liability_std = df["Liabilities"].std()

    metrics["liability_cv_pct"] = (
        liability_std /
        liability_mean * 100
        if liability_mean != 0
        else 0
    )

    # ---------------------------------------------------------
    # Monthly Trends
    # ---------------------------------------------------------

    metrics["avg_monthly_revenue_growth_pct"] = float(
        df["Revenue"].pct_change().mean() * 100
    )

    metrics["avg_monthly_asset_growth_pct"] = float(
        df["Assets"].pct_change().mean() * 100
    )

    metrics["avg_monthly_liability_growth_pct"] = float(
        df["Liabilities"].pct_change().mean() * 100
    )

    # ---------------------------------------------------------
    # Worst Month
    # ---------------------------------------------------------

    metrics["largest_monthly_revenue_drop_pct"] = abs(
        min(df["Revenue"].pct_change().fillna(0))
    ) * 100

    metrics["largest_monthly_liability_jump_pct"] = max(
        df["Liabilities"].pct_change().fillna(0)
    ) * 100

    # ---------------------------------------------------------
    # Simple Trend Labels
    # ---------------------------------------------------------

    def trend_label(growth_pct):
        if growth_pct > 10:
            return "Increasing"
        elif growth_pct < -10:
            return "Decreasing"
        return "Stable"

    metrics["revenue_trend"] = trend_label(
        metrics["revenue_growth_pct"]
    )

    metrics["asset_trend"] = trend_label(
        metrics["asset_growth_pct"]
    )

    metrics["liability_trend"] = trend_label(
        metrics["liability_growth_pct"]
    )

    metrics["contingent_trend"] = trend_label(
        metrics["contingent_growth_pct"]
    )

    metrics["utilization_trend"] = trend_label(
        growth(
            df.iloc[0]["UtilizationPct"],
            df.iloc[-1]["UtilizationPct"]
        )
    )

    return metrics
