CREATE  TABLE TIMESHEET_LOCK (
  LOCK_ID INTEGER NOT NULL,
  DATE_START TIMESTAMP NOT NULL ,
  DATE_END TIMESTAMP NOT NULL ,
  NAME VARCHAR(255) NULL ,
  PRIMARY KEY (LOCK_ID) );

CREATE INDEX TIMESHEET_LOCK_IDX ON TIMESHEET_LOCK (DATE_START, DATE_END);

UPDATE CONFIGURATION SET CONFIG_VALUE = '1.3' WHERE CONFIG_KEY = 'version';

