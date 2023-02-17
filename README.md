# HSE-Java-Lab1

This lab inlcudes realization of Java classes for work with **complex numbers** and **matrices**.

## Contents:
[Complex Number Class](#Complex-Numbers-Class)

[Matrix Class](#Matrix-Class)

## Complex Numbers Class

### 0. Class fields
Class contains two static fields:
* _round_ - for correct rounding double numbers
* _error_ - for protecting from too small errors

And two main fields:
* _real_ - for real part of complex number
* _imag_ - for imaginary part of complex number
```java
static DecimalFormat round = new DecimalFormat("#.###");
static double error = 1 * Math.pow(10, -10);

double real, imag;
```

### 1. Initialization
Complex number can be initialized in 3 ways.

```java
Complex number = new Complex();   // real = 0, imag = 0
```
```java
Complex number = new Complex(a, b);   // real = a, imag = b
```
```java
Complex number = new Complex(another_number);   // copy another_number
```

### 2. Input
> Use ComplexIO class to work with input and output of complex numbers

Method **.get()** waiting for keyboard input of _number.real_ and _number.imag_ separated with ' '.
```java
ComplexIO.get(number1);
```

### 3. Output
> Use ComplexIO class to work with input and output of complex numbers

Methods **.print()** and **.println()** outputs number in algebraic form
```java
ComplexIO.print(number1);     // printing without '\n'
ComplexIO.println(number1);   // printing with '\n'
```

### 4. Basic operations (+, -, **,* /)

Methods **.add()** and  **.sub()**  perform addition and subtraction operations **_in-place_**
```java
number1.add(number2);   // result: number1 = number1 + number2
number1.sub(number2);   // result: number1 = number1 - number2
```
Methods **.sum()**  and **.diff()** perform addition and subtraction operations with returning **_new object_**
```java
new_number = number1.sum(number2);   // result: new_number = number1 + number2
new_number = number1.diff(number2);    // result: new_number = number1 - number2
```
Method **.mul()** returns result of multiply of number1 and number2 with **_new object_**
```java
new_number = number1.mul(number2);   // result: new_number = number1 * number2
```
Method **.div()** returns result of division of number1 by number2 with **_new object_**
```java
new_number = number1.div(number2);   // result: new_number = number1 / number2
```

### 5. Module and Argumet
Method **.abs()** returns module of complex number
```java
double abs = number.abs();   // variable 'abs' contains module of complex number
```
Method **.arg()** returns argument of comlex number
```java
double arg = number.arg();    // variable 'arg' contains argument of complex number
```

### 6. Power and Root
Method **.pow()** returns **_new object_** which contains number powered in n<sub><sup>th</sub></sup> degree
```java
int n = 3
powered_number = number.pow(n);   // 'powered_number' contains (number)^3
```
Method **.sqrt()** returns **_new object_** which contains number root of the n<sub><sup>th</sub></sup> degree
```java
int n = 3
number_root = number.sqrt(n);   // 'number_root' contains (number)^(1/3)
```

### 7. Сonversion to String
Method **.asString()** returns string that contains algebraic notation of a complex number
```java
String number_str = ComplexIO.asString(number1); // number_str = "<real> + <imag>i"
```

## Matrix Class

### 0. Class fields
Class contains matrix field and fields of its dimension
```java
Complex[][] matrix;
int n, m;   // n - rows, m - cols
```

### 1. Initialization
Matrix can be initialized in 3 ways

The matrix can be initialized by dimension. In this case, it will be filled with zeros
```java
Matrix matrix = new Matrix(n, m);   // rows = n, cols = m
```
You can also specify double or complex number with the third argumet to fill matrix with this element
```java
Matrix matrix = new Matrix(n, m, number);   // rows = n, cols = m, each element = number
```
Initialize copy of another matrix
```java
Matrix matrix = new Matrix(another_matrix);   // copy another_matrix
```

### 2. Input
> Use MatrixIO class to work with input and output of matrix

Matrix can be filled from keyboard by method **.fill()**

Each element is entered on a new line and requires two numbers of the type double separated by ' '
```java
MatrixIO.fill(matrix);
```
Matrix can be also filled with **random numbers** of different types:
```java
MatrixIO.fillRandInt(matrix);   // fill matrix with random int numbers

MatrixIO.fillRandDouble(matrix);    // fill matrix with random double numbers

MatrixIO.fillRandComplex(matrix);     // fill matrix with random Complex numbers
```

### 3. Output
> Use MatrixIO class to work with input and output of matrix

Method **.print()** outputs matrix
```java
MatrixIO.print(matrix);
```

### 4. Basic operations (+, -, *)

Methods **.add()** and  **.sub()**  perform addition and subtraction operations **_in-place_**
```java
matrix1.add(matrix2);   // result: matrix1 = matrix1 + matrix2
matrix1.sub(matrix2);   // result: matrix1 = matrix1 - matrix2
```
Methods **.sum()**  and **.diff()** perform addition and subtraction operations with returning **_new object_**
```java
new_matrix = matrix1.sum(matrix2);   // result: new_matrix = matrix1 + matrix2
new_matrix = matrix1.diff(matrix2);    // result: new_matrix = matrix1 - matrix2
```
Method **.mul()** returns result of multiply of matrix1 and matrix2 with **_new object_**
```java
new_matrix = matrix1.mul(matrix2);   // result: new_matrix = matrix1 * matrix2
```
> All this methods can return DimentionError(< operation >) if operation cannot be performed due to an incorrect dimension

Matrix can be also multiply **_in-place_** on const of type double or Complex with method **.mul_number()**
```
matrix.mul_number(1.01);    // multiply matrix on 1.01
matrix.mul_number(new Complex(1, 3));   // multiply matrix on (1 + 3i)
```

### 5. Transposition
Matrix can be transposed **_in-place_** with method **.T()**
```java
matrix.T(); 
```

### 6. Power
Square matrix can be raised to the power of (int) n **_in-place_**, n > 0
```
int n = 2
matrix.pow(n);
```

### 7. Determinant
Square matrix NxN supports the calculation of the determinant
```java
Complex det = matrix.determinant();   // varaible 'det' contains determinant of matrix
```

### 8. Inverse

Method **.inverse()** returns inverse matrix if it possible
```java
matrix_inv = matrix.inverse();
```