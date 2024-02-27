CREATE TABLE MOVIES (
	MOVIE_ID VARCHAR2(20 CHAR) NOT NULL,
	TITLE VARCHAR2(100 CHAR) NOT NULL,
	MINIMUM_AGE NUMBER NOT NULL,
	OPEN_YEAR VARCHAR2(4 CHAR),
	RUNNING_TIME NUMBER,
	GENRE VARCHAR2(10 CHAR) NOT NULL,
	ATMOSPHERE VARCHAR2(10 CHAR),
	LOCATION VARCHAR2(20 CHAR) NOT NULL,
	SUMMARY CLOB NOT NULL,
	POSTER VARCHAR2(4000 CHAR)
)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	LOGGING
	NOCOMPRESS
	NOCACHE
	NOPARALLEL
	NOROWDEPENDENCIES
	DISABLE ROW MOVEMENT;

ALTER TABLE MOVIES
	MONITORING;

COMMENT ON TABLE MOVIES IS '영화에 대한 간략한 정보들';

COMMENT ON COLUMN MOVIES.MOVIE_ID IS '영화의 고유 번호';

COMMENT ON COLUMN MOVIES.TITLE IS '영화의 제목';

COMMENT ON COLUMN MOVIES.MINIMUM_AGE IS '관람가 정보';

COMMENT ON COLUMN MOVIES.OPEN_YEAR IS '개봉한 연도';

COMMENT ON COLUMN MOVIES.RUNNING_TIME IS '상영시간(분단위)';

COMMENT ON COLUMN MOVIES.GENRE IS '장르명';

COMMENT ON COLUMN MOVIES.ATMOSPHERE IS '영화의 분위기';

COMMENT ON COLUMN MOVIES.LOCATION IS '영화 제작 국가';

COMMENT ON COLUMN MOVIES.SUMMARY IS '간략한 줄거리';

COMMENT ON COLUMN MOVIES.POSTER IS '포스터 URL';

CREATE UNIQUE INDEX PK_MOVIES
	ON MOVIES (
		MOVIE_ID ASC
	)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	NOLOGGING
	NOCOMPRESS
	SORT
	NOPARALLEL;

ALTER INDEX PK_MOVIES NOMONITORING USAGE;

ALTER TABLE MOVIES
	ADD
		CONSTRAINT PK_MOVIES
		PRIMARY KEY (
			MOVIE_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

CREATE TABLE USERS (
	USER_ID VARCHAR2(30 CHAR) NOT NULL,
	NAME VARCHAR2(25 CHAR) NOT NULL,
	BACKGROUND VARCHAR2(4000 CHAR),
	PROFLE VARCHAR2(4000 CHAR)
)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	LOGGING
	NOCOMPRESS
	NOCACHE
	NOPARALLEL
	NOROWDEPENDENCIES
	DISABLE ROW MOVEMENT;

ALTER TABLE USERS
	MONITORING;

COMMENT ON TABLE USERS IS '회원 정보';

COMMENT ON COLUMN USERS.USER_ID IS '회원의 아이디';

COMMENT ON COLUMN USERS.NAME IS '사용자의 활동명(닉네임)';

COMMENT ON COLUMN USERS.BACKGROUND IS '배경사진의 URL';

COMMENT ON COLUMN USERS.PROFLE IS '프로필 사진의 URL';

CREATE UNIQUE INDEX PK_USERS
	ON USERS (
		USER_ID ASC
	)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	NOLOGGING
	NOCOMPRESS
	SORT
	NOPARALLEL;

ALTER INDEX PK_USERS NOMONITORING USAGE;

ALTER TABLE USERS
	ADD
		CONSTRAINT PK_USERS
		PRIMARY KEY (
			USER_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

CREATE TABLE DIRECTORS (
	DIRECTOR_ID VARCHAR2(20 CHAR) NOT NULL,
	NAME VARCHAR2(20 CHAR) NOT NULL,
	PROFLE VARCHAR2(4000 CHAR)
)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	LOGGING
	NOCOMPRESS
	NOCACHE
	NOPARALLEL
	NOROWDEPENDENCIES
	DISABLE ROW MOVEMENT;

ALTER TABLE DIRECTORS
	MONITORING;

COMMENT ON TABLE DIRECTORS IS '영화 감독의 간략한 정보';

COMMENT ON COLUMN DIRECTORS.DIRECTOR_ID IS '영화 감독의 고유 번호';

COMMENT ON COLUMN DIRECTORS.NAME IS '감독명';

COMMENT ON COLUMN DIRECTORS.PROFLE IS '감독의 프로필 사진 URL';

CREATE UNIQUE INDEX PK_DIRECTORS
	ON DIRECTORS (
		DIRECTOR_ID ASC
	)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	NOLOGGING
	NOCOMPRESS
	SORT
	NOPARALLEL;

ALTER INDEX PK_DIRECTORS NOMONITORING USAGE;

ALTER TABLE DIRECTORS
	ADD
		CONSTRAINT PK_DIRECTORS
		PRIMARY KEY (
			DIRECTOR_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

CREATE TABLE CASTS (
	CAST_ID VARCHAR2(20 CHAR) NOT NULL,
	ACTOR_ID VARCHAR2(20 CHAR) NOT NULL,
	MOVIE_ID VARCHAR2(20 CHAR) NOT NULL,
	CHARACTER_NAME VARCHAR2(20 CHAR),
	MAIN_ACTOR_YN CHAR(1 CHAR) DEFAULT 'N' NOT NULL
)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	LOGGING
	NOCOMPRESS
	NOCACHE
	NOPARALLEL
	NOROWDEPENDENCIES
	DISABLE ROW MOVEMENT;

ALTER TABLE CASTS
	MONITORING;

COMMENT ON TABLE CASTS IS '영화에 출연한 배우의 정보';

COMMENT ON COLUMN CASTS.CAST_ID IS '출연 배우의 고유 번호';

COMMENT ON COLUMN CASTS.ACTOR_ID IS '배우의 고유 번호';

COMMENT ON COLUMN CASTS.MOVIE_ID IS '영화의 고유 번호';

COMMENT ON COLUMN CASTS.CHARACTER_NAME IS '영화 내의 배우 역할명';

COMMENT ON COLUMN CASTS.MAIN_ACTOR_YN IS 'Y: 주연, N: 조연';

CREATE UNIQUE INDEX PK_CASTS
	ON CASTS (
		CAST_ID ASC
	)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	NOLOGGING
	NOCOMPRESS
	SORT
	NOPARALLEL;

ALTER INDEX PK_CASTS NOMONITORING USAGE;

ALTER TABLE CASTS
	ADD
		CONSTRAINT PK_CASTS
		PRIMARY KEY (
			CAST_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

CREATE TABLE ACTORS (
	ACTOR_ID VARCHAR2(20 CHAR) NOT NULL,
	PROFLE VARCHAR2(4000 CHAR),
	NAME VARCHAR2(20 CHAR) NOT NULL
)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	LOGGING
	NOCOMPRESS
	NOCACHE
	NOPARALLEL
	NOROWDEPENDENCIES
	DISABLE ROW MOVEMENT;

ALTER TABLE ACTORS
	MONITORING;

COMMENT ON TABLE ACTORS IS '배우의 간략한 정보';

COMMENT ON COLUMN ACTORS.ACTOR_ID IS '배우의 고유 번호';

COMMENT ON COLUMN ACTORS.PROFLE IS '배우의 프로필 사진 URL';

COMMENT ON COLUMN ACTORS.NAME IS '배우의 이름(활동명)';

CREATE UNIQUE INDEX PK_ACTORS
	ON ACTORS (
		ACTOR_ID ASC
	)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	NOLOGGING
	NOCOMPRESS
	SORT
	NOPARALLEL;

ALTER INDEX PK_ACTORS NOMONITORING USAGE;

ALTER TABLE ACTORS
	ADD
		CONSTRAINT PK_ACTORS
		PRIMARY KEY (
			ACTOR_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

CREATE TABLE PRODUCINGS (
	PRODUCING_ID VARCHAR2(20 CHAR) NOT NULL,
	DIRECTOR_ID VARCHAR2(20 CHAR) NOT NULL,
	MOVIE_ID VARCHAR2(20 CHAR) NOT NULL
)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	LOGGING
	NOCOMPRESS
	NOCACHE
	NOPARALLEL
	NOROWDEPENDENCIES
	DISABLE ROW MOVEMENT;

ALTER TABLE PRODUCINGS
	MONITORING;

COMMENT ON TABLE PRODUCINGS IS '영화를 제작한 감독의 정보';

COMMENT ON COLUMN PRODUCINGS.PRODUCING_ID IS '제작의 고유 번호';

COMMENT ON COLUMN PRODUCINGS.DIRECTOR_ID IS '영화 감독의 고유 번호';

COMMENT ON COLUMN PRODUCINGS.MOVIE_ID IS '영화의 고유 번호';

CREATE UNIQUE INDEX PK_PRODUCINGS
	ON PRODUCINGS (
		PRODUCING_ID ASC
	)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	NOLOGGING
	NOCOMPRESS
	SORT
	NOPARALLEL;

ALTER INDEX PK_PRODUCINGS NOMONITORING USAGE;

ALTER TABLE PRODUCINGS
	ADD
		CONSTRAINT PK_PRODUCINGS
		PRIMARY KEY (
			PRODUCING_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

CREATE TABLE RATINGS (
	RATING_ID VARCHAR2(20 CHAR) NOT NULL,
	USER_ID VARCHAR2(30 CHAR) NOT NULL,
	RATING NUMBER NOT NULL,
	DESCRIPTION VARCHAR2(300 CHAR),
	MOVIE_ID VARCHAR2(20 CHAR) NOT NULL
)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	LOGGING
	NOCOMPRESS
	NOCACHE
	NOPARALLEL
	NOROWDEPENDENCIES
	DISABLE ROW MOVEMENT;

ALTER TABLE RATINGS
	MONITORING;

COMMENT ON TABLE RATINGS IS '영화의 평점 정보';

COMMENT ON COLUMN RATINGS.RATING_ID IS '평점의 고유 번호';

COMMENT ON COLUMN RATINGS.USER_ID IS '회원의 아이디';

COMMENT ON COLUMN RATINGS.RATING IS '평가 점수';

COMMENT ON COLUMN RATINGS.DESCRIPTION IS '평가 내용';

COMMENT ON COLUMN RATINGS.MOVIE_ID IS '영화의 고유 번호';

CREATE UNIQUE INDEX PK_RATINGS
	ON RATINGS (
		RATING_ID ASC
	)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	NOLOGGING
	NOCOMPRESS
	SORT
	NOPARALLEL;

ALTER INDEX PK_RATINGS NOMONITORING USAGE;

ALTER TABLE RATINGS
	ADD
		CONSTRAINT PK_RATINGS
		PRIMARY KEY (
			RATING_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

CREATE TABLE FOLLOWS (
	FOLLOW_ID VARCHAR2(20 CHAR) NOT NULL,
	USER_ID VARCHAR2(30 CHAR) NOT NULL,
	FOLLOW_USER_ID VARCHAR2(30 CHAR) NOT NULL
)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	LOGGING
	NOCOMPRESS
	NOCACHE
	NOPARALLEL
	NOROWDEPENDENCIES
	DISABLE ROW MOVEMENT;

ALTER TABLE FOLLOWS
	MONITORING;

COMMENT ON TABLE FOLLOWS IS '회원의 팔로우 정보';

COMMENT ON COLUMN FOLLOWS.FOLLOW_ID IS '팔로우 회원의 고유 번호';

COMMENT ON COLUMN FOLLOWS.USER_ID IS '회원의 아이디';

COMMENT ON COLUMN FOLLOWS.FOLLOW_USER_ID IS '팔로우 대상 회원의 아이디';

CREATE UNIQUE INDEX PK_FOLLOWS
	ON FOLLOWS (
		FOLLOW_ID ASC
	)
	STORAGE (
		BUFFER_POOL DEFAULT
	)
	NOLOGGING
	NOCOMPRESS
	SORT
	NOPARALLEL;

ALTER INDEX PK_FOLLOWS NOMONITORING USAGE;

ALTER TABLE FOLLOWS
	ADD
		CONSTRAINT PK_FOLLOWS
		PRIMARY KEY (
			FOLLOW_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

ALTER TABLE CASTS
	ADD
		CONSTRAINT FK_ACTORS_TO_CASTS
		FOREIGN KEY (
			ACTOR_ID
		)
		REFERENCES ACTORS (
			ACTOR_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

ALTER TABLE CASTS
	ADD
		CONSTRAINT FK_MOVIES_TO_CASTS
		FOREIGN KEY (
			MOVIE_ID
		)
		REFERENCES MOVIES (
			MOVIE_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

ALTER TABLE PRODUCINGS
	ADD
		CONSTRAINT FK_MOVIES_TO_PRODUCINGS
		FOREIGN KEY (
			MOVIE_ID
		)
		REFERENCES MOVIES (
			MOVIE_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

ALTER TABLE PRODUCINGS
	ADD
		CONSTRAINT FK_DIRECTORS_TO_PRODUCINGS
		FOREIGN KEY (
			DIRECTOR_ID
		)
		REFERENCES DIRECTORS (
			DIRECTOR_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

ALTER TABLE RATINGS
	ADD
		CONSTRAINT FK_MOVIES_TO_RATINGS
		FOREIGN KEY (
			MOVIE_ID
		)
		REFERENCES MOVIES (
			MOVIE_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

ALTER TABLE RATINGS
	ADD
		CONSTRAINT FK_USERS_TO_RATINGS
		FOREIGN KEY (
			USER_ID
		)
		REFERENCES USERS (
			USER_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

ALTER TABLE FOLLOWS
	ADD
		CONSTRAINT FK_USERS_TO_FOLLOWS
		FOREIGN KEY (
			USER_ID
		)
		REFERENCES USERS (
			USER_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;

ALTER TABLE FOLLOWS
	ADD
		CONSTRAINT FK_USERS_TO_FOLLOWS2
		FOREIGN KEY (
			FOLLOW_USER_ID
		)
		REFERENCES USERS (
			USER_ID
		)
		NOT DEFERRABLE
		ENABLE
		VALIDATE;