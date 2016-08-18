# Search engine based on finite state machine in Java

This program receives an input string and look through the specified files for all instances of that string. The search algorithm is based on finite state machine created on the fly for every input. After finding all the matches some stats will be shown and a link to the pages within the word was found, this way the user can open these pages.

The time required for processing is virtually zero, which means that it is basically being bottlenecked by the hard drive speed, especially in a **Match case** scenario, and as expected, the first operation shows a slower reading time due to uncashed data.

## Author

Marcelo A. T. Gomes

## Test images

Here are a couple of tests performed on a SSD Samsung EVO 840 250GB and a CPU Intel Core i5 4200U @2,5GHz with 4 GB of DDR3 @1600 MHz RAM. All tested were performed several times, and the median result was picked.

### Test 1
![](https://s3.postimg.org/3t7i8w8tv/test_1.png)

### Test 2
![](https://s3.postimg.org/wgfcuhbo3/test_2.png)
