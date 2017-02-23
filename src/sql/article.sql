DROP SEQUENCE art_seq;
DROP TABLE Article;
-- seq, pat_id, title, content, regdate(), read_count --
-- CREATE SEQUENCE art_seq
CREATE SEQUENCE art_seq
	START WITH   1
 	INCREMENT BY 1
 	NOCACHE
 	NOCYCLE;
-- CREATE TABLE Article
CREATE TABLE Article(
	art_seq DECIMAL NOT NULL PRIMARY KEY,
	pat_id VARCHAR2(20) NOT NULL,
	title VARCHAR2(100) NOT NULL,
	content VARCHAR2(100) NOT NULL,
	regdate VARCHAR2(20) NOT NULL,
	read_count VARCHAR2(10) NOT NULL,
	FOREIGN KEY(pat_id) REFERENCES Patient(pat_id)
);
-- INSERT(11건)
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pahn', '1st 제목', '제목-1-내용-1', '2017-02-17', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pahn', '2nd 제목', '제목-2-내용-2', '2017-02-17', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pahn', '3rd 제목', '제목-3-내용-3', '2017-02-17', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pkim', '4th 제목', '제목-4-내용-4', '2017-02-17', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pkim', '5th 제목', '제목-5-내용-5', '2017-02-16', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'plee', '6th 제목', '제목-6-내용-6', '2017-02-16', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pchoi', '7th 제목', '제목-7-내용-7', '2017-02-16', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pchoi', '8th 제목', '제목-8-내용-8', '2017-02-16', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pjeon', '9th 제목', '제목-9-내용-9', '2017-02-15', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pjeon', '10th 제목', '제목-10-내용-10', '2017-02-15', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pjeon', '11th 제목', '제목-11-내용-11', '2017-02-15', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pjeon', '12th 제목', '제목-12-내용-12', '2017-02-15', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pyou', '13th 제목', '제목-13-내용-13', '2017-02-15', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pyou', '14th 제목', '제목-14-내용-14', '2017-02-14', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pyou', '15th 제목', '제목-15-내용-15', '2017-02-14', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pyou', '대한', '얼마나 역사를 봄바람이다', '2017-02-13', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pchoi2', '청춘', '그들의 인간이 보는 가치를 것이다', '2017-02-13', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pchoi2', '봄바람', '타오르고 인생을 만물은 봄바람', '2017-02-13', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'pchoi2', '그들', '우리 몸이 곳이 살 사막', '2017-02-13', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'plee2', '용감', '작고 위하여', '2017-02-12', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'plee2', '인간', '생명을 얼음이 갑 눈에 위하여', '2017-02-12', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'plee2', '소금', '관현악이며, 놀이 보내는 불러 심장의', '2017-02-11', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'poh', '꽃', '가지에 위하여서 청춘은 것이다', '2017-02-11', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'poh', '교향악', '모래뿐일 끓는 뿐이다', '2017-02-11', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'psong', '창공', '그들의 뜨고, 아니다', '2017-02-11', '1000000');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count)
VALUES(art_seq.nextval, 'psong', '그릇', '나는 빈그릇이요!', '2017-02-11', '1000000');
-- READ ALL
SELECT * FROM Article;
-- READ SOME
SELECT * FROM Article WHERE pat_id='2017-02-15';
-- READ ONE
SELECT * FROM Article WHERE art_seq=1;
-- UPDATE
UPDATE Article SET pat_id='정몽주', title='11th 제목', content='제목-11-내용-11', regdate='2017-02-15', read_count='7000000' WHERE art_seq = 11;
-- DELETE
DELETE FROM Article WHERE art_seq='2';
SELECT COUNT(*) AS count FROM Article;
SELECT art_seq, pat_id, title, content, regdate, read_count FROM Article WHERE title LIKE '%1st 제목%';