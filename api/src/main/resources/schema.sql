DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
    id          VARCHAR2(40)                     NOT NULL  PRIMARY KEY,
    price_id    INT                              NOT NULL,
    brand_id    INT                              NOT NULL,
    product_id  LONG                             NOT NULL,
    priority    INT DEFAULT 0                    NOT NULL,
    price       DOUBLE                           NOT NULL,
    currency    VARCHAR2(3)                      NOT NULL,
    start_date  VARCHAR2(10)                     NOT NULL,
    start_time  VARCHAR2(10)                     NOT NULL,
    end_date    VARCHAR2(10)                     NOT NULL,
    end_time    VARCHAR2(10)                     NOT NULL
);