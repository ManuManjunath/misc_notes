import unittest
from calculator import Calculator

class CalculatorTest(unittest.TestCase):

    # The TestCase.setUp method is used to set up initial parameters
    # This is called before every test method
    def setUp(self) -> None:
        self.a = 10
        self.b = -2

    # tearDown releases any resources that may have been reserved during setUp
    # Especially used if you're creating files or DB connections
    # This is called after every test method
    def tearDown(self) -> None:
        # variables a and b are in memory. So no need to release anything
        pass

    def test_add(self):
        addition = Calculator.add(self.a, self.b)
        self.assertEqual(addition, 8)

    def test_subtract(self):
        subtraction = Calculator.subtract(self.a, self.b)
        self.assertEqual(subtraction, 12)

    def test_multiply(self):
        multiplication = Calculator.multiply(self.a, self.b)
        self.assertEqual(multiplication, -20)

    # To skip a test from the test suite,
    @unittest.skip("WIP")
    def test_divide(self):
        division = Calculator.divide(self.a, self.b)
        self.assertEqual(division, -5)
