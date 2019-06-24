# CSCI 1133, Lab Section 011, HW 1 Lubna Mohamed Abdirahman, Problem 1B
print('This program converts fahrenheit temperatures to celsius and kelvin\n')
Tf = float(input('Please enter the temperature in Fahrenheit: '))
Tc = (Tf - 32) * 5/9
print ('The temperature in Celsius is: ', Tc)

Tk = (Tf -32)*5/9+ 273.15
print ('The temperature in Kelvin is: ', Tk)

if Tf <= 32:
    print('It is cold!')
elif Tf >32 and Tf < 70:
    print('It is cool.')
else: print('It is warm.')
