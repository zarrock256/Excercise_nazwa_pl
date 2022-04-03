Project: Excersise_nazwa_pl
Author: Kamil Nagórzański

Project is designed for automating test of logging into existing accout to nazwa.pl website.
It is Page Object Model pattern orientated, with required data exported to JSON file.

#Entities package
Config class allows to read from JSON file without worrying about exceptions.
Driver class extends ChromeDriver class. It has implemented secure methods of searching and waiting for elements
using FluentWait class.

#Actions package
Contains only action of logging into website.

#Pages package
Contains xpaths for proper page's web elements.

Steps of the test:
1) Type in login and password to the account.
2) Click "Zaloguj się" button.
3) Log in to mailbox of email provided for testing account.
4) Search mailbox for sent authorization code with proper request numeration.
5) Paste found authorization code into input required for two-factor authentication.
6) Click "Zaloguj się" button.
7) Verify if user has logged in properly.

To start test some data must be prepared dependently on the paths to required files:
CheckIfUserCanLogIn.java:22 - path to chromedriver.exe
CheckIfUserCanLogIn.java:24 - path to json file with required data such as login, password etc