#JK-Bank-Tracker

This project app is just a simple simulation project app which users can just create a bank account using information and after creating a bank account, initially get cash in their account and they can do whatever they want with it afterwards whether it's depositing cash or transferring cash etc. This similarly resembles to bank account apps in real life through various companies like barclays, HSBC etc. It's intended to be safe and protected to use.

#Intro

This class is just a 1 greeting message saying "This is the JK Bank App! Welcome and let's get you registered!" in a form of greeting. This is to make the app friendly and interactive as well as appreciating when the users use it.

#RegisterAccount

This is the first phase of the program where during the account making process, you enter personal information about yourself in order from: username, age, gender, phone number and email address so 5 pieces of information and there's a 3 attempt limit to each. The first thing the program will prompt you to ask within that phase is your username where you type your username and before you can type your age, you have to enter a valid username meeting all the requirements stated like nothing empty or not above a certain number of characters etc. You have 3 attempts and if you fail 3 attempts, you start again from the very beginning (this is to prevent users typing invalid information a million times which can potentially cause the program to crash or slow down). So even, if you have to type the last piece of information since you have 5 valid pieces of information, if you pass the 3 attempt limit on the 6th one, sadly, you have to go back to the very start and type your infos again so go back to typing a valid username. Also, the program does check for duplicate usernames so in this program, duplicate usernames aren't allowed because this would lead to confusion over who's who and that's why unique usernames are easier to identify. The duplicate usernames are also part of the 3 attempt limit too.

#Password

This is the second phase of the program but it is extremely similar in terms of procedure to the RegisterAccount phase but only 1 prompt pretty much which is to type the password towards the account you're creating (the 2nd prompt is just typing the same passord you typed in the 1st prompt). The 3 attempt limit applies exactly here too for both confirmPassword and passWord methods where both have the same (or at least similar requirements except for confirmPassword, both passwords have to be equal). Also, for this program, passwords should be unique so duplicate passwords aren't allowed too (again to avoid confusion). Again, the process restarts after passing the 3 attempt limit for either method (so entering password or entering confirm password regardless). After typing both valid password and confirm password, the program then generates a random 9 digit passcode for the user to use anytime when using it as well as logging in. Possibly depending on the number of users, 2 of them or maybe 3 or 4 or more may get the same passcode but the program uses a random number generator for that which is unpredictable too but however, it doesn't affect privacy too much especially for the unique username and unique password part.

#InitialMoneyTransfer

The user doesn't do anything here but this occurs after the user has entered all the valid information from the previous phases. After signing up, the program transfers 1000.00 pounds to the new user's account stating the 'Congratulations' message and 'Thank You' message. This code part is basically the informal interface part of the program which occurs after the user successfully finishes entering all the valid pieces of information and confirms it with the program app. This is crucial because by this, it makes the user appreciate the app more and also really friendly and easy (easygoing) to use whenever possible.

#Main

This is the main class which is the most important class in the entire program because it runs the entire program so without it, the program wouldn't even be possible to run. Most fundamental class of the entire full code.


