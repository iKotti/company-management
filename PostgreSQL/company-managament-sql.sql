-- This script was generated by a beta version of the ERD tool in pgAdmin 4
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.companies
(
    company_id integer NOT NULL,
    company_code character varying NOT NULL,
    company_title character varying NOT NULL,
    PRIMARY KEY (company_id)
);

CREATE TABLE public.employees
(
    employee_id integer NOT NULL,
    registration_number character varying NOT NULL,
    employee_name character varying NOT NULL,
    section_id integer NOT NULL,
    PRIMARY KEY (employee_id)
);

CREATE TABLE public.sections
(
    section_id integer NOT NULL,
    section_code character varying NOT NULL,
    section_name character varying NOT NULL,
    company_id integer NOT NULL,
    PRIMARY KEY (section_id)
);

ALTER TABLE public.employees
    ADD FOREIGN KEY (section_id)
    REFERENCES public.sections (section_id)
    NOT VALID;


ALTER TABLE public.sections
    ADD FOREIGN KEY (company_id)
    REFERENCES public.companies (company_id)
    NOT VALID;

END;