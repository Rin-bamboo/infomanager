select emptb0_.emp_id as emp_id1_0_, emptb0_.barthday as barthday2_0_, emptb0_.emp_name as emp_name3_0_, emptb0_.emp_name_kana as emp_name_kana4_0_ from emp_tb emptb0_;

--社員テーブル作成

DROP TABLE emp_tb;

CREATE TABLE emp_tb(
    emp_id          NUMBER(10)    PRIMARY KEY,
    emp_name        VARCHAR2(30)    NOT NULL,
    emp_name_kana   VARCHAR2(60)    NOT NULL,
    barthday        DATE            NOT NULL,
    tel_no          VARCHAR2(15)    NOT NULL,
    emg_tel_no      VARCHAR2(15)    NOT NULL,
    address_no      VARCHAR2(8)     NOT NULL,
    address         VARCHAR2(60)    NOT NULL,
    mail_address    VARCHAR2(60)    ,
    join_date       DATE            NOT NULL,
    bus_station     VARCHAR2(20),
    station         VARCHAR2(20),
    ret_date        DATE,
    die_date        DATE,
    delete_flg      NUMBER(1),
    insert_date     DATE,
    update_date     DATE
    );

SELECT * FROM emp_tb;

--シーケンス作成
CREATE SEQUENCE seq_emp_id
START WITH 1
NOCACHE;

--シーケンスの削除
DROP SEQUENCE seq_emp_id;

--社員データ作成
DELETE FROM emp_tb;

--社員テストデータの作成
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'山田　太郎','ヤマダ　タロウ','1994/10/5','080-1111-1111','03-2222-1111','243-0033','神奈川県厚木市温水1-2-1','e-mail1@mail.com','2022/1/1','神奈川バス１','厚木１','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'山田　花子','ヤマダ　ハナコ','2002/10/10','080-1111-2222','03-2222-2222','243-0033','神奈川県厚木市温水1-2-2','e-mail2@mail.com','2022/4/1','神奈川バス２','厚木２','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'田中　健','タナカ　ケン','1985/4/5','080-1111-3333','03-2222-3333','243-0033','神奈川県厚木市温水1-2-3','e-mail3@mail.com','2005/6/1','神奈川バス３','厚木３','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'桜井　七','サクライ　ナナ','1965/4/6','080-1111-4444','03-2222-4444','243-0033','神奈川県厚木市温水1-2-4','e-mail4@mail.com','1990/8/1','神奈川バス４','厚木４','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'三島　咲','ミシマ　サキ','2000/10/2','080-1111-5555','03-2222-5555','243-0033','神奈川県厚木市温水1-2-5','e-mail5@mail.com','2020/10/1','神奈川バス５','厚木５','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'山本　翔','ヤマモト　カケル','1999/8/5','080-1111-6666','03-2222-6666','243-0033','神奈川県厚木市温水1-2-6','e-mail6@mail.com','2022/7/1','神奈川バス６','厚木６','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'鬼瓦　十兵衛','オニガワラ　ジュウベイ','1936/10/4','080-1111-7777','03-2222-7777','243-0033','神奈川県厚木市温水1-2-7','e-mail7@mail.com','1956/3/1','神奈川バス７','厚木７','2000/1/1','','1',sysdate,sysdate);

INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'小宮山　太郎','コミヤヤマ　タロウ','1998/10/4','080-1111-8888','03-2222-7777','243-0033','神奈川県厚木市温水1-2-8','2013/3/1','神奈川バス8','厚木8','','','',sysdate,sysdate);

DELETE FROM emp_tb WHERE emp_id = '8';

--サロゲートキーの作成
DROP TABLE surrogete_key_tb;

CREATE TABLE surrogete_key_tb(
    emp_id          NUMBER(10) NOT NULL REFERENCES emp_tb(emp_id),
    surrogete_key   RAW(16) DEFAULT SYS_GUID(),
    issue_date      DATE,
    insert_date     DATE,
    update_date     Date
);

--サロゲートキーテーブルの削除
DELETE FROM surrogete_key_tb;

SELECT * FROM surrogete_key_tb
WHERE emp_id = '1';

--サロゲートキーテストデータ作成
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
(SELECT emp_id FROM surrogete_key_tb WHERE surrogete_key = '43780E4B30BB4BCC88CF3F85243C7065');

UPDATE surrogete_key_tb SET surrogete_key = SYS_GUID(),update_date = sysdate, issue_date = sysdate WHERE emp_id = '1';
--サロゲートキー解説
--https://www.web-dev-qa-db-ja.com/ja/oracle/oracle%E3%81%A7guid%E3%82%92%E7%94%9F%E6%88%90%E3%81%99%E3%82%8B%E6%96%B9%E6%B3%95%E3%81%AF%EF%BC%9F/969718678/