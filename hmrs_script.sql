--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-30 15:13:09

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
-- TOC entry 205 (class 1259 OID 16470)
-- Name: activation_code; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.activation_code (
    id integer NOT NULL,
    code character varying(500)[],
    is_verify boolean,
    user_id integer
);


ALTER TABLE public.activation_code OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16700)
-- Name: cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cities (
    city_id integer NOT NULL,
    city_name character varying(50) NOT NULL
);


ALTER TABLE public.cities OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16395)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    first_name character varying(50)[] NOT NULL,
    last_name character varying(50)[] NOT NULL,
    birth_date date,
    phone_number character varying(12)[],
    user_id integer NOT NULL,
    nationality_id character varying(11)[] NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16427)
-- Name: employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers (
    user_id integer NOT NULL,
    company_name character varying(255)[],
    web_site character varying(50)[],
    phone_number character varying(12)[],
    tax_number character varying(10)[],
    id integer NOT NULL
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16482)
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
-- TOC entry 210 (class 1259 OID 16722)
-- Name: job_adverst; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_adverst (
    position_id integer,
    city_id integer,
    min_salary integer,
    max_salary integer,
    quantity smallint,
    due_date date,
    description character varying(50)[],
    activity_status bit(1),
    job_advert_id integer NOT NULL,
    user_id integer NOT NULL,
    advert_date date
);


ALTER TABLE public.job_adverst OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16747)
-- Name: job_adverts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_adverts (
    job_advert_id integer NOT NULL,
    activity_status boolean,
    advert_date date,
    description character varying(255) NOT NULL,
    due_date date NOT NULL,
    max_salary real,
    min_salary real,
    quantity integer NOT NULL,
    city_id integer NOT NULL,
    user_id integer,
    position_id integer NOT NULL,
    id integer
);


ALTER TABLE public.job_adverts OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16745)
-- Name: job_adverts_job_advert_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.job_adverts_job_advert_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.job_adverts_job_advert_id_seq OWNER TO postgres;

--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 211
-- Name: job_adverts_job_advert_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.job_adverts_job_advert_id_seq OWNED BY public.job_adverts.job_advert_id;


--
-- TOC entry 203 (class 1259 OID 16419)
-- Name: positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.positions (
    position_id integer NOT NULL,
    position_name character varying(150)[]
);


ALTER TABLE public.positions OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16655)
-- Name: job_titles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.positions ALTER COLUMN position_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_titles_id_seq
    START WITH 3
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 213 (class 1259 OID 16753)
-- Name: system_employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.system_employee (
    date_of_start date NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    phone_number character varying(255) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.system_employee OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16398)
-- Name: system_employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.system_employees (
    first_name character varying(25)[],
    last_name character varying(25)[],
    phone_number character varying(11)[],
    date_of_start date,
    user_id integer
);


ALTER TABLE public.system_employees OWNER TO postgres;

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
-- TOC entry 208 (class 1259 OID 16688)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2900 (class 2604 OID 16750)
-- Name: job_adverts job_advert_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverts ALTER COLUMN job_advert_id SET DEFAULT nextval('public.job_adverts_job_advert_id_seq'::regclass);


--
-- TOC entry 2910 (class 2606 OID 16704)
-- Name: cities Cities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT "Cities_pkey" PRIMARY KEY (city_id);


--
-- TOC entry 2908 (class 2606 OID 16477)
-- Name: activation_code activation_code_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_code
    ADD CONSTRAINT activation_code_pkey PRIMARY KEY (id);


--
-- TOC entry 2906 (class 2606 OID 16434)
-- Name: employers employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2912 (class 2606 OID 16729)
-- Name: job_adverst job_adverst_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverst
    ADD CONSTRAINT job_adverst_pkey PRIMARY KEY (job_advert_id);


--
-- TOC entry 2914 (class 2606 OID 16752)
-- Name: job_adverts job_adverts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverts
    ADD CONSTRAINT job_adverts_pkey PRIMARY KEY (job_advert_id);


--
-- TOC entry 2904 (class 2606 OID 16426)
-- Name: positions job_titles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT job_titles_pkey PRIMARY KEY (position_id);


--
-- TOC entry 2916 (class 2606 OID 16760)
-- Name: system_employee system_employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employee
    ADD CONSTRAINT system_employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2902 (class 2606 OID 16413)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2924 (class 2606 OID 16735)
-- Name: job_adverst city_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverst
    ADD CONSTRAINT city_id FOREIGN KEY (city_id) REFERENCES public.cities(city_id) NOT VALID;


--
-- TOC entry 2929 (class 2606 OID 16791)
-- Name: job_adverts fk2wb8xnb9idlpeq0eprk12g26o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverts
    ADD CONSTRAINT fk2wb8xnb9idlpeq0eprk12g26o FOREIGN KEY (id) REFERENCES public.employers(user_id);


--
-- TOC entry 2930 (class 2606 OID 16786)
-- Name: system_employee fk8kurm29wk9vnq191hr734t41s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employee
    ADD CONSTRAINT fk8kurm29wk9vnq191hr734t41s FOREIGN KEY (id) REFERENCES public.users(id);


--
-- TOC entry 2918 (class 2606 OID 16761)
-- Name: employees fkd6th9xowehhf1kmmq1dsseq28; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fkd6th9xowehhf1kmmq1dsseq28 FOREIGN KEY (id) REFERENCES public.users(id);


--
-- TOC entry 2926 (class 2606 OID 16771)
-- Name: job_adverts fkeshbhuv73peilh3ohw5wu4bfs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverts
    ADD CONSTRAINT fkeshbhuv73peilh3ohw5wu4bfs FOREIGN KEY (city_id) REFERENCES public.cities(city_id);


--
-- TOC entry 2928 (class 2606 OID 16781)
-- Name: job_adverts fkfjllku7ixbx2fsuldxnd52lca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverts
    ADD CONSTRAINT fkfjllku7ixbx2fsuldxnd52lca FOREIGN KEY (position_id) REFERENCES public.positions(position_id);


--
-- TOC entry 2927 (class 2606 OID 16776)
-- Name: job_adverts fkma97wjt5im0k94r42u9yeq22y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverts
    ADD CONSTRAINT fkma97wjt5im0k94r42u9yeq22y FOREIGN KEY (user_id) REFERENCES public.employers(user_id);


--
-- TOC entry 2921 (class 2606 OID 16766)
-- Name: employers fknnl4ba0tc831e25ufip4ek2yq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT fknnl4ba0tc831e25ufip4ek2yq FOREIGN KEY (id) REFERENCES public.users(id);


--
-- TOC entry 2923 (class 2606 OID 16730)
-- Name: job_adverst position_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverst
    ADD CONSTRAINT position_id FOREIGN KEY (position_id) REFERENCES public.positions(position_id) NOT VALID;


--
-- TOC entry 2920 (class 2606 OID 16690)
-- Name: employers user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2917 (class 2606 OID 16695)
-- Name: employees user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2919 (class 2606 OID 16705)
-- Name: system_employees user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employees
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2922 (class 2606 OID 16717)
-- Name: activation_code user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_code
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2925 (class 2606 OID 16740)
-- Name: job_adverst user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_adverst
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 205
-- Name: TABLE activation_code; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.activation_code TO pg_monitor;


--
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 200
-- Name: TABLE employees; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.employees TO pg_monitor;


--
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 204
-- Name: TABLE employers; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.employers TO pg_monitor;


--
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE positions; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.positions TO pg_monitor;


--
-- TOC entry 3071 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE system_employees; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.system_employees TO pg_monitor;


--
-- TOC entry 3072 (class 0 OID 0)
-- Dependencies: 202
-- Name: TABLE users; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.users TO pg_monitor;


-- Completed on 2021-05-30 15:13:10

--
-- PostgreSQL database dump complete
--


