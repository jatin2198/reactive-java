-- Table: public.novel_details

-- DROP TABLE IF EXISTS public.novel_details;

CREATE TABLE IF NOT EXISTS public.novel_details
(
    novel_id integer NOT NULL,
    novel_name character varying(50) COLLATE pg_catalog."default",
    novel_desc character varying(100) COLLATE pg_catalog."default",
    author character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT novel_details_pkey PRIMARY KEY (novel_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.novel_details
    OWNER to postgres;