# hyperskill-Encryption-Decryption-Java

[Encryption Decryption](https://hyperskill.org/projects/46) provides a chance to become familiar with handling files and command line parameters, as well as learning some basic encryption techniques.


Code sample:

```
Example 1

Input:
> java Application -mode enc -key 7 -data "Welcome to Encryption-Decryption" -alg unicode

Output:
The input is: Welcome to Encryption-Decryption
The result is: ^lsjvtl'{v'Lujy w{pvu4Kljy w{pvu

Example 2

Input:
> java Application -mode enc -in road_to_treasure.txt -out protected.txt -key 7 -alg unicode

This command gets data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

Output:
The input to encrypt is: "I hope you enjoy learning java"
The result is: )P'ovwl' v|'luqv 'slhyupun'qh}h)

Example 3

Input:
> java Application -key 5 -alg shift -data "Bjqhtrj yt jshwduynts-ijhwduynts" -mode dec

Output:
The input is: Bjqhtrj yt jshwduynts-ijhwduynts
The result is: Welcome to encryption-decryption
```
