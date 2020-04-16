package com.mywork.sample.reactivedemo.test

import java.io.File
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException


fun main(args: Array<String>) {

    val fileName = "data.txt"

    val file = FileReader("C:\\test\\a.txt")
    val fileInput = BufferedReader(file)

    // Print first 3 lines of file "C:\test\a.txt"
    for (counter in 0..2)
        println(fileInput.readLine())

    fileInput.close()

    var file1 = File(fileName)

    var fileExists = file1.exists()

    if (fileExists) {
        print("$fileName does exist.")
    } else {
        print("$fileName does not exist.")
    }
}