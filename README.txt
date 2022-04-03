Excersise_nazwa_pl project is designed for automating test of logging into existing accout to nazwa.pl website.

Project is Page Object Model orientated, with required data exported to JSON file.

Config class allows to read from JSON file without worrying about exceptions.
Driver class extends ChromeDriver class. It has implemented secure methods of searching and waiting for elements
using FluentWait class.

Steps of the test:
1) Type in login and password to the account.
2) Click "Zaloguj się" button.
3) Log in to mailbox of email provided for testing account.
4) Search mailbox for sent authorization code with proper request numeration.
5) Paste found authorization code into input required for two-factor authentication.
6) Click "Zaloguj się" button.
7) Verify if user has logged in properly.

