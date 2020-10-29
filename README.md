# Text-generator
A text-generating program, based on a collection of text, in Java.
The algorithm is mainly about creating a hash map which associates to each sequence of n words (n being chosen as an argument) in the input text its prefix. Hence, the program will chose randomly for each word a sequence present in the original text and so on.<br\>
Special words are added to the original text to mark its start (since the first word in a file doesn't have a prefix), its end(to stop the algorithm) and the presence of different paragraphs.<br\>
I have provided as an exemple input some chapters of "Madame Bovary" by gustave flobert in French, properly formatted, and some chapters of "The Odyssey" and "The Illiad" by Homer, in a raw format. 
