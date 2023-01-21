import csv
import json

with open ("EjemploCSV.csv", 'r') as f:
    reader = csv.reader(f)
    # next(reader) # skip header
    data = {}
    # print(dir(reader))
    counter = 0
    for index in reader:
        if counter == 0:
            for row in index:
                data[row] = ''
            counter += 1
        else:
            for i in range(len(index)):
                data[list(data.keys())[i]] = index[i]

print(data)
