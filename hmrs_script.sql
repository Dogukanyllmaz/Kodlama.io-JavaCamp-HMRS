--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-12 21:11:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 208 (class 1259 OID 16470)
-- Name: activation_code; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.activation_code (
    id integer NOT NULL,
    activation_code character varying(38)[],
    is_confirmed boolean,
    confirmed_date date
);


ALTER TABLE public.activation_code OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16435)
-- Name: activation_code_to_candidates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.activation_code_to_candidates (
    id integer NOT NULL,
    candidate_id integer
);


ALTER TABLE public.activation_code_to_candidates OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16445)
-- Name: activation_code_to_employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.activation_code_to_employers (
    id integer NOT NULL,
    employer_id integer
);


ALTER TABLE public.activation_code_to_employers OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16398)
-- Name: candidates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidates (
    id integer NOT NULL,
    first_name character varying(25)[],
    last_name character varying(25)[],
    identity_number character varying(11)[],
    birth_date date
);


ALTER TABLE public.candidates OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16395)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    id integer NOT NULL,
    first_name character varying(50)[],
    last_name character varying(50)[]
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16455)
-- Name: employer_activation_by_employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employer_activation_by_employees (
    id integer NOT NULL,
    confirmed_employee_id integer,
    is_confirmed boolean,
    confirmed_date date,
    employer_id integer
);


ALTER TABLE public.employer_activation_by_employees OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16427)
-- Name: employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers (
    id integer NOT NULL,
    company_name character varying(255)[],
    web_address character varying(50)[],
    phone_number character varying(12)[],
    is_activated boolean
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16482)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16419)
-- Name: job_titles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_titles (
    id integer NOT NULL,
    title character varying(50)[]
);


ALTER TABLE public.job_titles OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16406)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(50)[],
    password character varying(25)[]
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 2891 (class 2606 OID 16405)
-- Name: candidates Candidates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT "Candidates_pkey" PRIMARY KEY (id);


--
-- TOC entry 2905 (class 2606 OID 16477)
-- Name: activation_code activation_code_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_code
    ADD CONSTRAINT activation_code_pkey PRIMARY KEY (id);


--
-- TOC entry 2899 (class 2606 OID 16439)
-- Name: activation_code_to_candidates activation_code_to_candidates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_code_to_candidates
    ADD CONSTRAINT activation_code_to_candidates_pkey PRIMARY KEY (id);


--
-- TOC entry 2901 (class 2606 OID 16449)
-- Name: activation_code_to_employers activation_code_to_employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_code_to_employers
    ADD CONSTRAINT activation_code_to_employers_pkey PRIMARY KEY (id);


--
-- TOC entry 2889 (class 2606 OID 16418)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- TOC entry 2903 (class 2606 OID 16459)
-- Name: employer_activation_by_employees employer_activation_by_employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer_activation_by_employees
    ADD CONSTRAINT employer_activation_by_employees_pkey PRIMARY KEY (id);


--
-- TOC entry 2897 (class 2606 OID 16434)
-- Name: employers employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (id);


--
-- TOC entry 2895 (class 2606 OID 16426)
-- Name: job_titles job_titles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_pkey PRIMARY KEY (id);


--
-- TOC entry 2893 (class 2606 OID 16413)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2906 (class 2606 OID 16440)
-- Name: activation_code_to_candidates candidate_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_code_to_candidates
    ADD CONSTRAINT candidate_id FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2909 (class 2606 OID 16465)
-- Name: employer_activation_by_employees confirmed_employee_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer_activation_by_employees
    ADD CONSTRAINT confirmed_employee_id FOREIGN KEY (confirmed_employee_id) REFERENCES public.employers(id);


--
-- TOC entry 2907 (class 2606 OID 16450)
-- Name: activation_code_to_employers employer_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_code_to_employers
    ADD CONSTRAINT employer_id FOREIGN KEY (employer_id) REFERENCES public.employers(id);


--
-- TOC entry 2908 (class 2606 OID 16460)
-- Name: employer_activation_by_employees employer_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer_activation_by_employees
    ADD CONSTRAINT employer_id FOREIGN KEY (employer_id) REFERENCES public.employers(id);


--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 208
-- Name: TABLE activation_code; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.activation_code TO pg_monitor;


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 205
-- Name: TABLE activation_code_to_candidates; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.activation_code_to_candidates TO pg_monitor;


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 206
-- Name: TABLE activation_code_to_employers; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.activation_code_to_employers TO pg_monitor;


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE candidates; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.candidates TO pg_monitor;


--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 200
-- Name: TABLE employees; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.employees TO pg_monitor;


--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 207
-- Name: TABLE employer_activation_by_employees; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.employer_activation_by_employees TO pg_monitor;


--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 204
-- Name: TABLE employers; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.employers TO pg_monitor;


--
-- TOC entry 3052 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE job_titles; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.job_titles TO pg_monitor;


--
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 202
-- Name: TABLE users; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.users TO pg_monitor;


-- Completed on 2021-05-12 21:11:32

--
-- PostgreSQL database dump complete
--

