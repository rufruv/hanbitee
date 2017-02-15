DROP SEQUENCE art_seq;
DROP TABLE Article;
-- seq, id, title, contents, regdate(), read_count --
-- CREATE SEQUENCE art_seq
CREATE SEQUENCE art_seq
	START WITH   1
 	INCREMENT BY 1
 	NOCACHE
 	NOCYCLE;
-- CREATE TABLE Article
CREATE TABLE Article(
	art_seq DECIMAL PRIMARY KEY,
	id VARCHAR2(20),
	title VARCHAR2(100),
	contents VARCHAR2(100),
	regdate VARCHAR2(20),
	read_count VARCHAR2(10)
);
-- INSERT(11건)
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '홍길동', '1st 제목', '제목-1-내용-1', '2017-02-17', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '홍길동', '2nd 제목', '제목-2-내용-2', '2017-02-17', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '홍길동', '3rd 제목', '제목-3-내용-3', '2017-02-17', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '유관순', '4th 제목', '제목-4-내용-4', '2017-02-17', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '안중근', '5th 제목', '제목-5-내용-5', '2017-02-16', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '허균', '6th 제목', '제목-6-내용-6', '2017-02-16', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '윤봉길', '7th 제목', '제목-7-내용-7', '2017-02-16', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '정약용', '8th 제목', '제목-8-내용-8', '2017-02-16', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '박지원', '9th 제목', '제목-9-내용-9', '2017-02-15', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '이방원', '10th 제목', '제목-10-내용-10', '2017-02-15', '1000000');
INSERT INTO Article(art_seq, id, title, contents, regdate, read_count)
VALUES(art_seq.nextval, '정몽주', '11th 제목', '제목-11-내용-11', '2017-02-15', '1000000');
-- READ ALL
SELECT * FROM Article;
-- READ SOME
SELECT * FROM Article WHERE id='2017-02-15';
-- READ ONE
SELECT * FROM Article WHERE art_seq=1;
-- UPDATE
UPDATE Article SET id='정몽주', title='11th 제목', contents='제목-11-내용-11', regdate='2017-02-15', read_count='7000000' WHERE art_seq = 11;
-- DELETE
DELETE FROM Article WHERE art_seq='2';