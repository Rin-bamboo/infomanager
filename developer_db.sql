--���[�U�[�쐬
CREATE USER spring_user IDENTIFIED BY bamboo1223;
--�����ݒ�
GRANT ALL PRIVILEGES TO spring_user;

--�Ј��e�[�u���쐬

DROP TABLE emp_tb;

CREATE TABLE emp_tb(
    emp_id          NUMBER(10)    PRIMARY KEY,
    emp_name        VARCHAR2(30)    NOT NULL,
    emp_name_kana   VARCHAR2(60)    NOT NULL,
    barthday        DATE           NOT NULL,
    tel_no          VARCHAR2(15)    NOT NULL,
    emg_tel_no      VARCHAR2(15)    NOT NULL,
    address_no      VARCHAR2(8)     NOT NULL,
    address         VARCHAR2(60)    NOT NULL,
    join_date       DATE            NOT NULL,
    bus_station     VARCHAR2(20),
    station         VARCHAR2(20),
    red_date        DATE,
    die_date        DATE,
    delete_flg      NUMBER(1),
    insert_date     DATE,
    update_date     DATE
    );
    
SELECT * FROM emp_tb;

--�V�[�P���X�쐬
CREATE SEQUENCE seq_emp_id
START WITH 1
NOCACHE;

--�V�[�P���X�̍폜
DROP SEQUENCE seq_emp_id;

--�Ј��f�[�^�쐬
DELETE FROM emp_tb;

--�Ј��e�X�g�f�[�^�̍쐬
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'�R�c�@���Y','���}�_�@�^���E','1994/10/5','080-1111-1111','03-2222-1111','243-0033','�_�ސ쌧���؎s����1-2-1','2022/1/1','�_�ސ�o�X�P','���؂P','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'�R�c�@�Ԏq','���}�_�@�n�i�R','2002/10/10','080-1111-2222','03-2222-2222','243-0033','�_�ސ쌧���؎s����1-2-2','2022/4/1','�_�ސ�o�X�Q','���؂Q','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'�c���@��','�^�i�J�@�P��','1985/4/5','080-1111-3333','03-2222-3333','243-0033','�_�ސ쌧���؎s����1-2-3','2005/6/1','�_�ސ�o�X�R','���؂R','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'����@��','�T�N���C�@�i�i','1965/4/6','080-1111-4444','03-2222-4444','243-0033','�_�ސ쌧���؎s����1-2-4','1990/8/1','�_�ސ�o�X�S','���؂S','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'�O���@��','�~�V�}�@�T�L','2000/10/2','080-1111-5555','03-2222-5555','243-0033','�_�ސ쌧���؎s����1-2-5','2020/10/1','�_�ސ�o�X�T','���؂T','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'�R�{�@��','���}���g�@�J�P��','1999/8/5','080-1111-6666','03-2222-6666','243-0033','�_�ސ쌧���؎s����1-2-6','2022/7/1','�_�ސ�o�X�U','���؂U','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'�S���@�\���q','�I�j�K�����@�W���E�x�C','1936/10/4','080-1111-7777','03-2222-7777','243-0033','�_�ސ쌧���؎s����1-2-7','1956/3/1','�_�ސ�o�X�V','���؂V','2000/1/1','','1',sysdate,sysdate);


--�T���Q�[�g�L�[�̍쐬
DROP TABLE surrogete_key_tb;

CREATE TABLE surrogete_key_tb(
    emp_id          NUMBER(10) NOT NULL REFERENCES emp_tb(emp_id),
    surrogete_key   RAW(16) DEFAULT SYS_GUID(),
    issue_date      DATE,
    insert_date     DATE,
    update_date     Date
);

--�T���Q�[�g�L�[�e�[�u���̍폜
DELETE FROM surrogete_key_tb;

SELECT * FROM surrogete_key_tb
WHERE emp_id = '1';

--�T���Q�[�g�L�[�e�X�g�f�[�^�쐬
INSERT INTO surrogete_key_tb VALUES('1',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('2',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('3',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('4',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('5',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('6',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('7',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);

SELECT SYS_GUID() FROM DUAL;

SELECT * FROM emp_tb
WHERE emp_id = 
(SELECT emp_id FROM surrogete_key_tb WHERE surrogete_key = 'F1245D0236584512ABBDCC94A568BC0A');

UPDATE surrogete_key_tb SET surrogete_key = SYS_GUID(),update_date = sysdate, issue_date = sysdate WHERE emp_id = '1';
--�T���Q�[�g�L�[���
--https://www.web-dev-qa-db-ja.com/ja/oracle/oracle%E3%81%A7guid%E3%82%92%E7%94%9F%E6%88%90%E3%81%99%E3%82%8B%E6%96%B9%E6%B3%95%E3%81%AF%EF%BC%9F/969718678/
