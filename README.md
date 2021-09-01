# CsvtoXml

Demo project about taking data from csv file and transforming into xml form. This project using [CSV libary](https://www.csvreader.com/java_csv_samples.php), 
[Freemarker](https://freemarker.apache.org/) for reading data from .csv folder and converting to xml file.

## SETUP AND INSTALLATION

1. Clone the repo from github or download the project and extract the project from ZIP.

> git clone https://github.com/Valkymorie/csvtoXml

2. Open the project.
3. Add external jars to project such as [CSV libary](https://www.csvreader.com/java_csv_samples.php) and [Freemarker](https://freemarker.apache.org/)
4. Before starting the project, you need to remark your project file path into ConverController.java source code for xml template config.
5.Run the project

### HOW TO USE
While the project running, csv libary is taking data from input.csv file and converting into new model of User as List. After this process, list of User is mapping into 
new data-model for transforming into brad new xml file. Finally freemaker libary takes data model and xml tamplate to converts to output.xml file. While this project
running, xml files is showing content at terminal.
