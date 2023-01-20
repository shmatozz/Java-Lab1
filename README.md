# HSE-Java-Lab1

This lab inlcudes realization of Java classes for work with **complex numbers** and **matrices**.

## Contents:
[Complex Number Class](#Complex-Numbers-Class)

[Matrix Class](#Matrix-Class)

## Complex Number Class

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
Complex number can be initialized with 3 ways.

```java
Complex number = new Complex();   // real = 0, imag = 0
```
```java
Complex number = new Complex(1, 2);   // real = 1, imag = 2
```
```java
Complex number = new Complex(another_number);   // copy another_number
```

### 2. Input
Method **.get()** waiting for keyboard input of _number.real_ and _number.imag_ separated with ' '.
```java
number.get();
```

### 3. Output
Methods **.print()** and **.println()** outputs number in algebraic form
```java
number.print();     // printing without '\n'
number.println();   // printing with '\n'
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
String number_str = number.asString();    // number_str = "<real> + <imag>i"
```

## Matrix Class
