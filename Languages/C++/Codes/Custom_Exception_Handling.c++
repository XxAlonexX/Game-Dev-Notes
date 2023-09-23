class MyException : public exception {};

int main() {
  try {
    // Do something that could throw an exception.
    // For example, open a file that might not exist.
    // Or, divide by zero.

    // If an exception is thrown, the catch block will be executed.
  } catch (MyException& e) {
    // Handle the custom exception.
    cout << "MyException caught: " << e.what() << endl;
    return 1;
  } catch (exception& e) {
    // Handle other exceptions.
    cout << "Exception caught: " << e.what() << endl;
    return 1;
  }

  // If no exception is thrown, the program will continue to execute here.

  return 0;
}
