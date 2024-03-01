#!/usr/bin/env python3
import csv,argparse
import sys
from pathlib import Path
import re
def validateQuestion(records):
    return [a and b for a,b in zip(
        [len(r)==6 for r in records],
        [True if r[5].strip().isdigit() and int(r[5])>=1 and int(r[5])<=4 else False for r in records])]

def validateRating(records):
    return [a and b for a,b in zip(
        [len(r)==2 for r in records],
        [True if r[0].strip().isdigit() and int(r[1])>=0 and int(r[1])<=5 else False for r in records])]

def validateAnswer(records):
    return [a and b for a,b in zip(
        [len(r)==2 for r in records],
        [True if r[0].strip().isdigit() and int(r[1])>=1 and int(r[1])<=4 else False for r in records])]

def validateVote(records):
    return [a and b for a,b in zip(
        [len(r)==1 for r in records],
        [True if r[0].strip().isdigit() and int(r[0])>=1 and int(r[0])<=9 else False for r in records])]

#filename must be studentId.csv                       
def validateFileName(filePath):
    return re.match("^\d+.csv$",Path(filePath).name.strip()) 

def validateCSV(filePath,format,records):
    if not validateFileName(filePath):
        return False,"Error:Invalid file name. It should be yourid.csv (your ID is only digits)"
    if (format=="q"):
        validLine=validateQuestion(records)
    elif (format=="a"):
        validLine=validateAnswer(records)
    elif (format=="r"):
        validLine=validateRating(records)
    elif (format=="v"):
        validLine=validateVote(records)
    else:
        return False,"Error:unrecognized format!.. skipping check"

    return True, "\n".join(["Valid" if v else "Invalid" for v in validLine])+ f"\n# valid records: {len([v for v in validLine if v])}"

def loadCSV(filePath):
        try:
            with open(filePath, newline='',mode='r', encoding='utf-8-sig',errors='replace') as f:
                records=[r for r in csv.reader(f,escapechar='\\') if len(r)]
                return records
        except Exception as e:
            print(f' Error reading file: {e}, check your file format! ',file = sys.stderr )

parser = argparse.ArgumentParser( description='Validate your file format upon submission. You must select one validation format corresponding to your file, along with your file path', epilog="Example:  to verify a questions file: formatChecker.py -f q 123456.csv")
parser.add_argument("-f","--format",choices=["q","a","r","v"],required=True,help="file format to validate {question|answer|rating|vote}")
parser.add_argument("file",help="path to your id.csv file. ")
args=parser.parse_args()
records=loadCSV(args.file)
if records:
    #alas no Either :(
    res,msg=validateCSV(args.file,args.format,records)
    if res:
        print(msg)
    else:
        print(msg,file=sys.stderr)
