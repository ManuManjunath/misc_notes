# calculator.py

class Calculator:
    """
    Simple calculator app to test unittest
    """

    def __init__(self, a, b):
        """
        Setup generic variables
        """
        print(f"The first value is {a} and the second value is {b}")
        a = self.a
        b = self.b

    def add(a, b):
        """
        :param: Enter 2 integers or floats
        :return: The sum of the 2 numbers
        :rtype: integer or floar
        """
        addition = a + b
        return addition

    def subtract(a, b):
        """
        :param: Enter 2 integers or floats
        :return: The difference 1st and 2nd number
        :rtype: integer or floar
        """
        subtraction = a - b
        return subtraction

    def multiply(a, b):
        """
        :param: Enter 2 integers or floats
        :return: The product of the 2 numbers
        :rtype: integer or floar
        """
        multiplication = a * b
        return multiplication

    def divide(a, b):
        """
        :param: Enter 2 integers or floats
        :return: The sum of the 2 numbers
        :rtype: integer or floar unless you're trying to divide by 0
        """
        if b == 0:
            raise ValueError('Cannot divide by 0')
        division = a / b
        return division
