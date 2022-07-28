--社員テーブル作成

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
    dep_id          NUMBER(1)       REFERENCES dep_tb(dep_id),
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

--社員テーブル削除
DROP TABLE emp_tb;


--シーケンス作成
CREATE SEQUENCE seq_emp_id
START WITH 1
NOCACHE;

--シーケンスの削除
DROP SEQUENCE seq_dep_id;

--社員データ削除
DELETE FROM emp_tb;

--社員テストデータの作成
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'山田　太郎','ヤマダ　タロウ','1994/10/5','080-1111-1111','03-2222-1111','243-0033','神奈川県厚木市温水1-2-1','e-mail1@mail.com','1','2022/1/1','神奈川バス１','厚木１','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'山田　花子','ヤマダ　ハナコ','2002/10/10','080-1111-2222','03-2222-2222','243-0033','神奈川県厚木市温水1-2-2','e-mail2@mail.com','2','2022/4/1','神奈川バス２','厚木２','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'田中　健','タナカ　ケン','1985/4/5','080-1111-3333','03-2222-3333','243-0033','神奈川県厚木市温水1-2-3','e-mail3@mail.com','3','2005/6/1','神奈川バス３','厚木３','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'桜井　七','サクライ　ナナ','1965/4/6','080-1111-4444','03-2222-4444','243-0033','神奈川県厚木市温水1-2-4','e-mail4@mail.com','1','1990/8/1','神奈川バス４','厚木４','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'三島　咲','ミシマ　サキ','2000/10/2','080-1111-5555','03-2222-5555','243-0033','神奈川県厚木市温水1-2-5','e-mail5@mail.com','3','2020/10/1','神奈川バス５','厚木５','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'山本　翔','ヤマモト　カケル','1999/8/5','080-1111-6666','03-2222-6666','243-0033','神奈川県厚木市温水1-2-6','e-mail6@mail.com','3','2022/7/1','神奈川バス６','厚木６','','','',sysdate,sysdate);
INSERT INTO emp_tb VALUES(seq_emp_id.NEXTVAL,'鬼瓦　十兵衛','オニガワラ　ジュウベイ','1936/10/4','080-1111-7777','03-2222-7777','243-0033','神奈川県厚木市温水1-2-7','e-mail7@mail.com','2','1956/3/1','神奈川バス７','厚木７','2000/1/1','','1',sysdate,sysdate);


--サロゲートキーテーブルの削除
DROP TABLE surrogete_key_tb;

--サロゲートキーの作成
CREATE TABLE surrogete_key_tb(
    emp_id          NUMBER(10) NOT NULL REFERENCES emp_tb(emp_id),
    surrogete_key   RAW(16) DEFAULT SYS_GUID(),
    issue_date      DATE,
    insert_date     DATE,
    update_date     Date
);

--サロゲートキーデータの削除
DELETE FROM surrogete_key_tb;


--サロゲートキーテストデータ作成
INSERT INTO surrogete_key_tb VALUES('1',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('2',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('3',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('4',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('5',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('6',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);
INSERT INTO surrogete_key_tb VALUES('7',SYS_GUID(),SYSDATE,SYSDATE,SYSDATE);


--サロゲートキー解説
--https://www.web-dev-qa-db-ja.com/ja/oracle/oracle%E3%81%A7guid%E3%82%92%E7%94%9F%E6%88%90%E3%81%99%E3%82%8B%E6%96%B9%E6%B3%95%E3%81%AF%EF%BC%9F/969718678/

--部署情報

CREATE TABLE dep_tb(
    dep_id      NUMBER(10)      PRIMARY KEY,
    dep_name    VARCHAR2(30)    NOT NULL,
    insert_date DATE,
    update_date DATE
);
DROP TABLE dep_tb;


--シーケンス作成
CREATE SEQUENCE seq_dep_id
START WITH 1
NOCACHE;

--部署データ作成
INSERT INTO dep_tb VALUES(seq_dep_id.NEXTVAL,'人事部',SYSDATE,SYSDATE);
INSERT INTO dep_tb VALUES(seq_dep_id.NEXTVAL,'総務部',SYSDATE,SYSDATE);
INSERT INTO dep_tb VALUES(seq_dep_id.NEXTVAL,'経理部',SYSDATE,SYSDATE);
INSERT INTO dep_tb VALUES(seq_dep_id.NEXTVAL,'営業部',SYSDATE,SYSDATE);

--社員・部署中間テーブル作成
DROP TABLE emp_dep_tb;

CREATE TABLE emp_dep_tb(
    link_emp_dep_id NUMBER  PRIMARY KEY,
    emp_id          NUMBER  NOT NULL REFERENCES emp_tb(emp_id),
    dep_id          NUMBER  NOT NULL REFERENCES dep_tb(dep_id),
    mult_flg        NUMBER,
    insert_date     DATE,
    update_date     DATE
);

--シーケンス作成
CREATE SEQUENCE link_emp_dep_id
START WITH 1
NOCACHE;

--社員部署中間テーブル作成
INSERT INTO emp_dep_tb VALUES(link_emp_dep_id.NEXTVAL,'1','1',null,SYSDATE,SYSDATE);
INSERT INTO emp_dep_tb VALUES(link_emp_dep_id.NEXTVAL,'2','2',null,SYSDATE,SYSDATE);
INSERT INTO emp_dep_tb VALUES(link_emp_dep_id.NEXTVAL,'3','3',null,SYSDATE,SYSDATE);
INSERT INTO emp_dep_tb VALUES(link_emp_dep_id.NEXTVAL,'4','4',null,SYSDATE,SYSDATE);
INSERT INTO emp_dep_tb VALUES(link_emp_dep_id.NEXTVAL,'5','2',null,SYSDATE,SYSDATE);
INSERT INTO emp_dep_tb VALUES(link_emp_dep_id.NEXTVAL,'7','3',null,SYSDATE,SYSDATE);
INSERT INTO emp_dep_tb VALUES(link_emp_dep_id.NEXTVAL,'2','2','1',SYSDATE,SYSDATE);
INSERT INTO emp_dep_tb VALUES(link_emp_dep_id.NEXTVAL,'4','4','1',SYSDATE,SYSDATE);
