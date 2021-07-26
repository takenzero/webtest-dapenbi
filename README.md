==========================================
PROJECT DESCRIPTION
==========================================

------------------------------------------
FEATURES :
------------------------------------------
Registration Writer Module :
- Use randomly generated data
- Write new rows to the CSV file
- This should word as a CRON job

Registration Reader Module :
- Read CSV with following fields :
  (NIP, NAME, DATE_OF_BIRTH, GENDER, ADDRESS, ID_NUMBER, PHONE_NUMBER)

- Function to register SIM :
  - Validation :
    > No Filed should be empty
    > NAME shouldn't have any special character
    > GENDER can only be F or M
    > ADDRESS must at least be 20 characters long
    > ID_NUMBER should be a mix of characters & numbers
    > PHONE_NUMBER should comply to country's standard (e.g. +66)
    > NIP can't be duplicated

  - For each validated record, save a new file with name as <NIP>.txt and put all info there.

  - Send welcome SMS to registered user's phone numbers
    > Different message for both genders
    > SMS function can just be log line

  - Console output with status for each registration
    > for rejected registration, print the reason on logs

------------------------------------------
PROJECT INFO
------------------------------------------
EDITOR			: MS VISUAL STUDIO CODE
PROGRAMMING LANGUAGE	: JAVA SPRING-BOOT
DEPENDENCY TOOLS		: MAVEN
JAVA VERSION		: 8

------------------------------------------
DEPENDECY LIBRARIES
------------------------------------------
> SPRING-BOOT VALIDATION
> JAVA FAKER
> APACHE COMMON CSV

------------------------------------------
PROJECT STRUCTURE
------------------------------------------
> src\main\java\com\dapenbi
  - dto
    - SimRegistrationDto.java
    - WriterDto.java
  - schedular
    - RegistrationWriterJob.java
    - RegistrtationReader.java
  - services
    - ReaderService.java
    - WriterService.java
  - utilities
    - DataGeneratorUtility.java
    - FileCsvUtility.java
    - FileTxtUtility.java
    - SendSmsUtility.java
    - ValidationUtility.java
  - validator
    - NipUniqueConstraint.java
    - NipUniqueValidator.java
  - WebtestDapenbiApplication.java
> uploads/files
  - Data.csv
  - valid_nip
    - <NIP>.txt