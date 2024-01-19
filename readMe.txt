It reads each line from the log file, 
identifies lines that indicate a failed login attempt 
(marked with the word "Invalid"), 
and extracts the IP address responsible for the attempt. 
The program then counts the number of failed attempts from each IP address. 
If an IP address has failed to login three or more times, 
it is recorded in an output file.
I used a HashMap<String, Integer> 
to track the number of failed login attempts for each IP address. 
The key is the IP address (String), 
and the value is the count of failed attempts (Integer). 
I used BufferedReader and PrintWriter wrapped around FileReader 
and FileWriter, respectively, for reading from and writing to files.
I used a try-catch block to handle IOException, 
ensuring the program does not crash due to file-related errors. 
The error message and stack trace are printed to 
assist in debugging if an error occurs.