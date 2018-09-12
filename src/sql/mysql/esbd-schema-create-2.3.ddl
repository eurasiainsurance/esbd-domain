CREATE TABLE ESBD_VER_2_3 (DUMMY INTEGER NOT NULL, PRIMARY KEY (DUMMY))
CREATE TABLE DICTIONARY (ID INTEGER NOT NULL, DTYPE VARCHAR(31), CODE VARCHAR(255), NAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE INSURANCE_AGENT (ID INTEGER NOT NULL, LETTER_OF_ATTORNEY_NUMBER VARCHAR(255), CONTRACT_DATE_OF DATE, CONTRACT_NUMBER VARCHAR(255), CREATED_INSTANT DATETIME, CREATED_AUTHOR_ID INTEGER, MODIFIED_INSTANT DATETIME, MODIFIED_AUTHOR_ID INTEGER, BRANCH_ID INTEGER, OWNER_ID INTEGER, SUBJECT_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE POLICY_DRIVER (ID INTEGER NOT NULL, DRIVING_EXPIRIENCE INTEGER, INSURANCE_CLASS_TYPE VARCHAR(255), INSURED_AGE_EXPIRIENCE_CLASS VARCHAR(255), MARITAL_STATUS VARCHAR(255), CREATED_INSTANT DATETIME, CREATED_AUTHOR_ID INTEGER, DRIVER_LICENSE_DATE_OF_ISSUE DATE, DRIVER_LICENSE_NUMBER VARCHAR(255), GPW_CERTIFICATE_DATE_OF_ISSUE DATE, GPW_CERTIFICATE_NUMBER VARCHAR(255), HANDICAPED_CERTIFICATE_DATE_OF_ISSUE DATE, HANDICAPED_CERTIFICATE_NUMBER VARCHAR(255), HANDICAPED_CERTIFICATE_VALID_FROM DATE, HANDICAPED_CERTIFICATE_VALID_TILL DATE, MODIFIED_INSTANT DATETIME, MODIFIED_AUTHOR_ID INTEGER, PENSIONER_CERTIFICATE_DATE_OF_ISSUE DATE, PENSIONER_CERTIFICATE_NUMBER VARCHAR(255), PRIVILEGER_DOCUMENT_DATE_OF_ISSUE DATE, PRIVILEGER_DOCUMENT_NUMBER VARCHAR(255), PRIVILEGER_DOCUMENT_TYPE VARCHAR(255), INSURED_PERSON_ID INTEGER, INSURER_ID INTEGER, POLICY_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE POLICY (ID INTEGER NOT NULL, ACTUAL_PREMIUM DOUBLE, CALCULATED_PREMIUM DOUBLE, COMMENTS VARCHAR(255), DATE_OF_ISSUE DATE, DATE_OF_PAYMENT DATE, INSURANT_PERSON_TYPE VARCHAR(255), INTERNAL_NUMBER VARCHAR(255), NUMBER VARCHAR(255), PAYMENT_TYPE VARCHAR(255), REISSUED_POLICY_ID INTEGER, VALID_FROM DATE, VALID_TILL DATE, CANCELATION_DATE_OF DATE, CANCELATION_REASON VARCHAR(255), CREATED_INSTANT DATETIME, CREATED_AUTHOR_ID INTEGER, MODIFIED_INSTANT DATETIME, MODIFIED_AUTHOR_ID INTEGER, BRANCH_ID INTEGER, INSURANCE_AGENT_ID INTEGER, INSURANT_ID INTEGER, INSURER_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE POLICY_VEHICLE (ID INTEGER NOT NULL, CURRENT_ODOMETER_VALUE INTEGER, VEHICLE_AGE_CLASS VARCHAR(255), VEHICLE_CLASS VARCHAR(255), VEHICLE_PURPOSE VARCHAR(255), VEGICLE_CERTIFICATE_DATE_OF_ISSUE DATE, VEGICLE_CERTIFICATE_NUMBER VARCHAR(255), VEGICLE_CERTIFICATE_MAJOR_CITY TINYINT(1) default 0, VEGICLE_CERTIFICATE_REGNUM VARCHAR(255), VEGICLE_CERTIFICATE_REGION VARCHAR(255), CREATED_INSTANT DATETIME, CREATED_AUTHOR_ID INTEGER, MODIFIED_INSTANT DATETIME, MODIFIED_AUTHOR_ID INTEGER, INSURER_ID INTEGER, VEHICLE_ID INTEGER, POLICY_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE SUBJECT (ID INTEGER NOT NULL, DTYPE VARCHAR(31), COMMENTS VARCHAR(255), ECONOMICS_SECTOR VARCHAR(255), ID_NUMBER VARCHAR(255), RESIDENT TINYINT(1) default 0, TAX_PAYER_NUMBER VARCHAR(255), CONTACT_EMAIL VARCHAR(255), CONTACT_HOME_ADDRESS VARCHAR(255), CONTACT_PHONE VARCHAR(255), CONTACT_SITE_URL VARCHAR(255), ORIGIN_CITY VARCHAR(255), ORIGIN_COUNTRY VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE SUBJECT_COMPANY (ID INTEGER NOT NULL, ACCOUNTANT_NAME VARCHAR(255), COMPANY_NAME VARCHAR(255), HEAD_NAME VARCHAR(255), COMPANY_ACTIVITY_KIND_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE SUBJECT_PERSON (ID INTEGER NOT NULL, IDENTITY_CARD_DATE_OF_ISSUE DATE, IDENTITY_CARD_TYPE VARCHAR(255), ISSUINGAUTHORITY VARCHAR(255), IDENTITY_CARD_NUMBER VARCHAR(255), PERSONAL_DATE_OF_BIRTH DATE, PERSONAL_GENDER VARCHAR(255), PERSONAL_NAME VARCHAR(255), PERSONAL_PATRONYMIC VARCHAR(255), PERSONAL_SURENAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE USER (ID INTEGER NOT NULL, AUTHENTIFICATED TINYINT(1) default 0, LAST_ACTIVITY DATETIME, LAST_SESSION_ID VARCHAR(255), LOGIN VARCHAR(255), BRANCH_ID INTEGER, ORGANIZATION_ID INTEGER, SUBJECT_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE VEHICLE (ID INTEGER NOT NULL, COLOR VARCHAR(255), RELEASE_DATE DATE, STEERING_WHEEL_LOCATION VARCHAR(255), VEHICLE_CLASS VARCHAR(255), VIN_CODE VARCHAR(255), VEHICLE_ENGINE_NUMBER VARCHAR(255), VEHICLE_ENGINE_POWER INTEGER, VEHICLE_ENGINE_VOLUME INTEGER, VEHICLE_MODEL_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE VEHICLE_MANUFACTURER (ID INTEGER NOT NULL, FOREIGN TINYINT(1) default 0, NAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE VEHICLE_MODEL (ID INTEGER NOT NULL, NAME VARCHAR(255), VEHICLE_MANUFACTURER_ID INTEGER, PRIMARY KEY (ID))
ALTER TABLE INSURANCE_AGENT ADD CONSTRAINT FK_INSURANCE_AGENT_MODIFIED_AUTHOR_ID FOREIGN KEY (MODIFIED_AUTHOR_ID) REFERENCES USER (ID)
ALTER TABLE INSURANCE_AGENT ADD CONSTRAINT FK_INSURANCE_AGENT_BRANCH_ID FOREIGN KEY (BRANCH_ID) REFERENCES DICTIONARY (ID)
ALTER TABLE INSURANCE_AGENT ADD CONSTRAINT FK_INSURANCE_AGENT_OWNER_ID FOREIGN KEY (OWNER_ID) REFERENCES USER (ID)
ALTER TABLE INSURANCE_AGENT ADD CONSTRAINT FK_INSURANCE_AGENT_SUBJECT_ID FOREIGN KEY (SUBJECT_ID) REFERENCES SUBJECT (ID)
ALTER TABLE INSURANCE_AGENT ADD CONSTRAINT FK_INSURANCE_AGENT_CREATED_AUTHOR_ID FOREIGN KEY (CREATED_AUTHOR_ID) REFERENCES USER (ID)
ALTER TABLE POLICY_DRIVER ADD CONSTRAINT FK_POLICY_DRIVER_POLICY_ID FOREIGN KEY (POLICY_ID) REFERENCES POLICY (ID)
ALTER TABLE POLICY_DRIVER ADD CONSTRAINT FK_POLICY_DRIVER_MODIFIED_AUTHOR_ID FOREIGN KEY (MODIFIED_AUTHOR_ID) REFERENCES USER (ID)
ALTER TABLE POLICY_DRIVER ADD CONSTRAINT FK_POLICY_DRIVER_CREATED_AUTHOR_ID FOREIGN KEY (CREATED_AUTHOR_ID) REFERENCES USER (ID)
ALTER TABLE POLICY_DRIVER ADD CONSTRAINT FK_POLICY_DRIVER_INSURED_PERSON_ID FOREIGN KEY (INSURED_PERSON_ID) REFERENCES SUBJECT (ID)
ALTER TABLE POLICY_DRIVER ADD CONSTRAINT FK_POLICY_DRIVER_INSURER_ID FOREIGN KEY (INSURER_ID) REFERENCES DICTIONARY (ID)
ALTER TABLE POLICY ADD CONSTRAINT FK_POLICY_BRANCH_ID FOREIGN KEY (BRANCH_ID) REFERENCES DICTIONARY (ID)
ALTER TABLE POLICY ADD CONSTRAINT FK_POLICY_CREATED_AUTHOR_ID FOREIGN KEY (CREATED_AUTHOR_ID) REFERENCES USER (ID)
ALTER TABLE POLICY ADD CONSTRAINT FK_POLICY_MODIFIED_AUTHOR_ID FOREIGN KEY (MODIFIED_AUTHOR_ID) REFERENCES USER (ID)
ALTER TABLE POLICY ADD CONSTRAINT FK_POLICY_INSURER_ID FOREIGN KEY (INSURER_ID) REFERENCES DICTIONARY (ID)
ALTER TABLE POLICY ADD CONSTRAINT FK_POLICY_INSURANCE_AGENT_ID FOREIGN KEY (INSURANCE_AGENT_ID) REFERENCES INSURANCE_AGENT (ID)
ALTER TABLE POLICY ADD CONSTRAINT FK_POLICY_INSURANT_ID FOREIGN KEY (INSURANT_ID) REFERENCES SUBJECT (ID)
ALTER TABLE POLICY_VEHICLE ADD CONSTRAINT FK_POLICY_VEHICLE_VEHICLE_ID FOREIGN KEY (VEHICLE_ID) REFERENCES VEHICLE (ID)
ALTER TABLE POLICY_VEHICLE ADD CONSTRAINT FK_POLICY_VEHICLE_MODIFIED_AUTHOR_ID FOREIGN KEY (MODIFIED_AUTHOR_ID) REFERENCES USER (ID)
ALTER TABLE POLICY_VEHICLE ADD CONSTRAINT FK_POLICY_VEHICLE_POLICY_ID FOREIGN KEY (POLICY_ID) REFERENCES POLICY (ID)
ALTER TABLE POLICY_VEHICLE ADD CONSTRAINT FK_POLICY_VEHICLE_INSURER_ID FOREIGN KEY (INSURER_ID) REFERENCES DICTIONARY (ID)
ALTER TABLE POLICY_VEHICLE ADD CONSTRAINT FK_POLICY_VEHICLE_CREATED_AUTHOR_ID FOREIGN KEY (CREATED_AUTHOR_ID) REFERENCES USER (ID)
ALTER TABLE SUBJECT_COMPANY ADD CONSTRAINT FK_SUBJECT_COMPANY_COMPANY_ACTIVITY_KIND_ID FOREIGN KEY (COMPANY_ACTIVITY_KIND_ID) REFERENCES DICTIONARY (ID)
ALTER TABLE SUBJECT_COMPANY ADD CONSTRAINT FK_SUBJECT_COMPANY_ID FOREIGN KEY (ID) REFERENCES SUBJECT (ID)
ALTER TABLE SUBJECT_PERSON ADD CONSTRAINT FK_SUBJECT_PERSON_ID FOREIGN KEY (ID) REFERENCES SUBJECT (ID)
ALTER TABLE USER ADD CONSTRAINT FK_USER_ORGANIZATION_ID FOREIGN KEY (ORGANIZATION_ID) REFERENCES DICTIONARY (ID)
ALTER TABLE USER ADD CONSTRAINT FK_USER_SUBJECT_ID FOREIGN KEY (SUBJECT_ID) REFERENCES SUBJECT (ID)
ALTER TABLE USER ADD CONSTRAINT FK_USER_BRANCH_ID FOREIGN KEY (BRANCH_ID) REFERENCES DICTIONARY (ID)
ALTER TABLE VEHICLE ADD CONSTRAINT FK_VEHICLE_VEHICLE_MODEL_ID FOREIGN KEY (VEHICLE_MODEL_ID) REFERENCES VEHICLE_MODEL (ID)
ALTER TABLE VEHICLE_MODEL ADD CONSTRAINT FK_VEHICLE_MODEL_VEHICLE_MANUFACTURER_ID FOREIGN KEY (VEHICLE_MANUFACTURER_ID) REFERENCES VEHICLE_MANUFACTURER (ID)
