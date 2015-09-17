# BudgetManager
Java Program for logging in purchases and managing finances. Makes use of swing and MySQL.


dataProcessing:
	DataProcessor - A DataProcessor object is a way of connecting to a MySQL DB and retrieving data.
	Created in a way to make it easy to reuse for future projects. This code is still in progress and does
	not yet include methods for insertions into a DB.
	
	Purchase - A purchase object mirrors an existing table in MySQL. Will change as it becomes clearer
	what information is neccessary to collect when a user logs a purchase.
