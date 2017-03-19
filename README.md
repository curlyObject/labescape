Run the project by executing `./gradlew bootRun` and then navigate to http://localhost:8080/src/index.html

Example input

	OOOOOOOOOO
	O    O   O
	O OO O O O
	O  O O O O
	O OO   O  
	O OOOOOOOO
	O        O
	OOOOOOOOOO
	
Starting point: (x=3, y=1)
 	
 	OOOOOOOOOO
	O    O   O
	O OO O O O
	O• O O O O
	O OO   O  
	O OOOOOOOO
	O        O
	OOOOOOOOOO
	
Desired output:
	
	OOOOOOOOOO
	O••••O•••O
	O•OO•O•O•O
	O• O•O•O•O
	O OO•••O••
	O OOOOOOOO
	O        O
	OOOOOOOOOO