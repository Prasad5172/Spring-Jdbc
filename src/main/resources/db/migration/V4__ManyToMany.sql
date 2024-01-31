CREATE TABLE MOVIE_STORE(
    MOVIE_ID INTEGER NOT NULL,
    ACTOR_ID INTEGER NOT NULL,
    CONSTRAINT FK_MOVIE_STORE_MOVIE_ID FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(ID),
    CONSTRAINT FK_MOVIE_STORE_ACTOR_ID FOREIGN KEY (ACTOR_ID) REFERENCES ACTOR(ID),
    PRIMARY KEY(MOVIE_ID,ACTOR_ID)
)