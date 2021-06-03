--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-06-03 18:16:12

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
-- TOC entry 202 (class 1259 OID 17232)
-- Name: activation_code; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.activation_code (
    id integer NOT NULL,
    code character varying(255),
    is_verify boolean,
    user_id integer
);


ALTER TABLE public.activation_code OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 17230)
-- Name: activation_code_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.activation_code_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.activation_code_id_seq OWNER TO postgres;

--
-- TOC entry 3160 (class 0 OID 0)
-- Dependencies: 201
-- Name: activation_code_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.activation_code_id_seq OWNED BY public.activation_code.id;


--
-- TOC entry 204 (class 1259 OID 17240)
-- Name: cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cities (
    city_id integer NOT NULL,
    city_name character varying(255)
);


ALTER TABLE public.cities OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17238)
-- Name: cities_city_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cities_city_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cities_city_id_seq OWNER TO postgres;

--
-- TOC entry 3161 (class 0 OID 0)
-- Dependencies: 203
-- Name: cities_city_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cities_city_id_seq OWNED BY public.cities.city_id;


--
-- TOC entry 206 (class 1259 OID 17248)
-- Name: confirms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.confirms (
    id integer NOT NULL
);


ALTER TABLE public.confirms OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17246)
-- Name: confirms_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.confirms_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.confirms_id_seq OWNER TO postgres;

--
-- TOC entry 3162 (class 0 OID 0)
-- Dependencies: 205
-- Name: confirms_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.confirms_id_seq OWNED BY public.confirms.id;


--
-- TOC entry 208 (class 1259 OID 17256)
-- Name: curriculum_vitaes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curriculum_vitaes (
    id integer NOT NULL,
    create_date date NOT NULL,
    description character varying(255),
    github_link character varying(255),
    "linkedın_link" character varying(255),
    photo_link character varying(255)
);


ALTER TABLE public.curriculum_vitaes OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17254)
-- Name: curriculum_vitaes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.curriculum_vitaes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.curriculum_vitaes_id_seq OWNER TO postgres;

--
-- TOC entry 3163 (class 0 OID 0)
-- Dependencies: 207
-- Name: curriculum_vitaes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.curriculum_vitaes_id_seq OWNED BY public.curriculum_vitaes.id;


--
-- TOC entry 209 (class 1259 OID 17265)
-- Name: email_confirms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.email_confirms (
    date_of_confirm date,
    is_confirm boolean NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.email_confirms OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17270)
-- Name: email_confirms_to_employer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.email_confirms_to_employer (
    id integer NOT NULL,
    employer_id integer
);


ALTER TABLE public.email_confirms_to_employer OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 17275)
-- Name: email_confirms_to_job_seeker; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.email_confirms_to_job_seeker (
    id integer NOT NULL,
    job_seeker_id integer
);


ALTER TABLE public.email_confirms_to_job_seeker OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 17280)
-- Name: employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers (
    company_name character varying(255) NOT NULL,
    phone_number character varying(255) NOT NULL,
    web_site character varying(255) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16482)
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
-- TOC entry 214 (class 1259 OID 17290)
-- Name: job_advertisements; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_advertisements (
    id integer NOT NULL,
    application_deadline date,
    description character varying(255) NOT NULL,
    max_salary real,
    min_salary real,
    number_of_open_position smallint NOT NULL,
    release_date date NOT NULL,
    city_id integer NOT NULL,
    user_id integer,
    position_id integer NOT NULL,
    active boolean NOT NULL,
    employer_id integer
);


ALTER TABLE public.job_advertisements OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 17288)
-- Name: job_advertisements_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.job_advertisements_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.job_advertisements_id_seq OWNER TO postgres;

--
-- TOC entry 3164 (class 0 OID 0)
-- Dependencies: 213
-- Name: job_advertisements_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.job_advertisements_id_seq OWNED BY public.job_advertisements.id;


--
-- TOC entry 215 (class 1259 OID 17296)
-- Name: job_seekers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_seekers (
    date_of_birth date NOT NULL,
    first_name character varying(255) NOT NULL,
    gender character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    nationality_id character varying(255) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.job_seekers OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 17306)
-- Name: languages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.languages (
    id integer NOT NULL,
    add_date date NOT NULL,
    degree smallint NOT NULL,
    name character varying(255) NOT NULL,
    curriculum_vitae_id integer
);


ALTER TABLE public.languages OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 17304)
-- Name: languages_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.languages_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.languages_id_seq OWNER TO postgres;

--
-- TOC entry 3165 (class 0 OID 0)
-- Dependencies: 216
-- Name: languages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.languages_id_seq OWNED BY public.languages.id;


--
-- TOC entry 219 (class 1259 OID 17314)
-- Name: positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.positions (
    id integer NOT NULL,
    position_name character varying(255) NOT NULL
);


ALTER TABLE public.positions OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 17312)
-- Name: positions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.positions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.positions_id_seq OWNER TO postgres;

--
-- TOC entry 3166 (class 0 OID 0)
-- Dependencies: 218
-- Name: positions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.positions_id_seq OWNED BY public.positions.id;


--
-- TOC entry 221 (class 1259 OID 17322)
-- Name: schools; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.schools (
    id integer NOT NULL,
    add_date date NOT NULL,
    department character varying(255),
    end_date date,
    name character varying(255) NOT NULL,
    start_date date NOT NULL,
    curriculum_vitae_id integer
);


ALTER TABLE public.schools OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 17320)
-- Name: schools_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.schools_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.schools_id_seq OWNER TO postgres;

--
-- TOC entry 3167 (class 0 OID 0)
-- Dependencies: 220
-- Name: schools_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.schools_id_seq OWNED BY public.schools.id;


--
-- TOC entry 222 (class 1259 OID 17331)
-- Name: system_employee_confirms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.system_employee_confirms (
    date_of_confirm date,
    is_confirm boolean NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.system_employee_confirms OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 17336)
-- Name: system_employee_confirms_to_employer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.system_employee_confirms_to_employer (
    id integer NOT NULL,
    employer_id integer
);


ALTER TABLE public.system_employee_confirms_to_employer OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 17341)
-- Name: system_employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.system_employees (
    date_of_birth date NOT NULL,
    first_name character varying(255) NOT NULL,
    gender character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    nationality_id character varying(255) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.system_employees OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 17351)
-- Name: technology_knowledges; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.technology_knowledges (
    id integer NOT NULL,
    add_date date NOT NULL,
    name character varying(255) NOT NULL,
    curriculum_vitae_id integer
);


ALTER TABLE public.technology_knowledges OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 17349)
-- Name: technology_knowledges_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.technology_knowledges_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.technology_knowledges_id_seq OWNER TO postgres;

--
-- TOC entry 3168 (class 0 OID 0)
-- Dependencies: 225
-- Name: technology_knowledges_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.technology_knowledges_id_seq OWNED BY public.technology_knowledges.id;


--
-- TOC entry 228 (class 1259 OID 17359)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 17357)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3169 (class 0 OID 0)
-- Dependencies: 227
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 230 (class 1259 OID 17370)
-- Name: work_experiences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.work_experiences (
    id integer NOT NULL,
    add_date date NOT NULL,
    end_date date,
    position_name character varying(255) NOT NULL,
    start_date date NOT NULL,
    work_place_name character varying(255) NOT NULL,
    curriculum_vitae_id integer
);


ALTER TABLE public.work_experiences OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 17368)
-- Name: work_experiences_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.work_experiences_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.work_experiences_id_seq OWNER TO postgres;

--
-- TOC entry 3170 (class 0 OID 0)
-- Dependencies: 229
-- Name: work_experiences_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.work_experiences_id_seq OWNED BY public.work_experiences.id;


--
-- TOC entry 2951 (class 2604 OID 17235)
-- Name: activation_code id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_code ALTER COLUMN id SET DEFAULT nextval('public.activation_code_id_seq'::regclass);


--
-- TOC entry 2952 (class 2604 OID 17243)
-- Name: cities city_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities ALTER COLUMN city_id SET DEFAULT nextval('public.cities_city_id_seq'::regclass);


--
-- TOC entry 2953 (class 2604 OID 17251)
-- Name: confirms id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.confirms ALTER COLUMN id SET DEFAULT nextval('public.confirms_id_seq'::regclass);


--
-- TOC entry 2954 (class 2604 OID 17259)
-- Name: curriculum_vitaes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curriculum_vitaes ALTER COLUMN id SET DEFAULT nextval('public.curriculum_vitaes_id_seq'::regclass);


--
-- TOC entry 2955 (class 2604 OID 17293)
-- Name: job_advertisements id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements ALTER COLUMN id SET DEFAULT nextval('public.job_advertisements_id_seq'::regclass);


--
-- TOC entry 2956 (class 2604 OID 17309)
-- Name: languages id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages ALTER COLUMN id SET DEFAULT nextval('public.languages_id_seq'::regclass);


--
-- TOC entry 2957 (class 2604 OID 17317)
-- Name: positions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.positions ALTER COLUMN id SET DEFAULT nextval('public.positions_id_seq'::regclass);


--
-- TOC entry 2958 (class 2604 OID 17325)
-- Name: schools id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schools ALTER COLUMN id SET DEFAULT nextval('public.schools_id_seq'::regclass);


--
-- TOC entry 2959 (class 2604 OID 17354)
-- Name: technology_knowledges id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.technology_knowledges ALTER COLUMN id SET DEFAULT nextval('public.technology_knowledges_id_seq'::regclass);


--
-- TOC entry 2960 (class 2604 OID 17362)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2961 (class 2604 OID 17373)
-- Name: work_experiences id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work_experiences ALTER COLUMN id SET DEFAULT nextval('public.work_experiences_id_seq'::regclass);


--
-- TOC entry 2963 (class 2606 OID 17237)
-- Name: activation_code activation_code_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activation_code
    ADD CONSTRAINT activation_code_pkey PRIMARY KEY (id);


--
-- TOC entry 2965 (class 2606 OID 17245)
-- Name: cities cities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (city_id);


--
-- TOC entry 2967 (class 2606 OID 17253)
-- Name: confirms confirms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.confirms
    ADD CONSTRAINT confirms_pkey PRIMARY KEY (id);


--
-- TOC entry 2969 (class 2606 OID 17264)
-- Name: curriculum_vitaes curriculum_vitaes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curriculum_vitaes
    ADD CONSTRAINT curriculum_vitaes_pkey PRIMARY KEY (id);


--
-- TOC entry 2971 (class 2606 OID 17269)
-- Name: email_confirms email_confirms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_confirms
    ADD CONSTRAINT email_confirms_pkey PRIMARY KEY (id);


--
-- TOC entry 2973 (class 2606 OID 17274)
-- Name: email_confirms_to_employer email_confirms_to_employer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_confirms_to_employer
    ADD CONSTRAINT email_confirms_to_employer_pkey PRIMARY KEY (id);


--
-- TOC entry 2975 (class 2606 OID 17279)
-- Name: email_confirms_to_job_seeker email_confirms_to_job_seeker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_confirms_to_job_seeker
    ADD CONSTRAINT email_confirms_to_job_seeker_pkey PRIMARY KEY (id);


--
-- TOC entry 2977 (class 2606 OID 17287)
-- Name: employers employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (id);


--
-- TOC entry 2979 (class 2606 OID 17295)
-- Name: job_advertisements job_advertisements_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT job_advertisements_pkey PRIMARY KEY (id);


--
-- TOC entry 2981 (class 2606 OID 17303)
-- Name: job_seekers job_seekers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT job_seekers_pkey PRIMARY KEY (id);


--
-- TOC entry 2985 (class 2606 OID 17311)
-- Name: languages languages_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (id);


--
-- TOC entry 2987 (class 2606 OID 17319)
-- Name: positions positions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);


--
-- TOC entry 2991 (class 2606 OID 17330)
-- Name: schools schools_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schools
    ADD CONSTRAINT schools_pkey PRIMARY KEY (id);


--
-- TOC entry 2993 (class 2606 OID 17335)
-- Name: system_employee_confirms system_employee_confirms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employee_confirms
    ADD CONSTRAINT system_employee_confirms_pkey PRIMARY KEY (id);


--
-- TOC entry 2995 (class 2606 OID 17340)
-- Name: system_employee_confirms_to_employer system_employee_confirms_to_employer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employee_confirms_to_employer
    ADD CONSTRAINT system_employee_confirms_to_employer_pkey PRIMARY KEY (id);


--
-- TOC entry 2997 (class 2606 OID 17348)
-- Name: system_employees system_employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employees
    ADD CONSTRAINT system_employees_pkey PRIMARY KEY (id);


--
-- TOC entry 2999 (class 2606 OID 17356)
-- Name: technology_knowledges technology_knowledges_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.technology_knowledges
    ADD CONSTRAINT technology_knowledges_pkey PRIMARY KEY (id);


--
-- TOC entry 2983 (class 2606 OID 17380)
-- Name: job_seekers uk_5i979vvfyyyyaflxu844h02j8; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT uk_5i979vvfyyyyaflxu844h02j8 UNIQUE (nationality_id);


--
-- TOC entry 3001 (class 2606 OID 17384)
-- Name: users uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- TOC entry 2989 (class 2606 OID 17382)
-- Name: positions uk_b6lkwasxdrfpxihi038w6ixt6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT uk_b6lkwasxdrfpxihi038w6ixt6 UNIQUE (position_name);


--
-- TOC entry 3003 (class 2606 OID 17367)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3005 (class 2606 OID 17378)
-- Name: work_experiences work_experiences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work_experiences
    ADD CONSTRAINT work_experiences_pkey PRIMARY KEY (id);


--
-- TOC entry 3023 (class 2606 OID 17465)
-- Name: technology_knowledges fk1aq8g1f08xplg5jska4y7okxv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.technology_knowledges
    ADD CONSTRAINT fk1aq8g1f08xplg5jska4y7okxv FOREIGN KEY (curriculum_vitae_id) REFERENCES public.curriculum_vitaes(id);


--
-- TOC entry 3015 (class 2606 OID 17476)
-- Name: job_advertisements fk1oyoicgy5q2gg0v1bb5r6kg2s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT fk1oyoicgy5q2gg0v1bb5r6kg2s FOREIGN KEY (employer_id) REFERENCES public.employers(id);


--
-- TOC entry 3009 (class 2606 OID 17400)
-- Name: email_confirms_to_job_seeker fk2oqspgusta5et6u2rqfv7yr6v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_confirms_to_job_seeker
    ADD CONSTRAINT fk2oqspgusta5et6u2rqfv7yr6v FOREIGN KEY (job_seeker_id) REFERENCES public.job_seekers(id);


--
-- TOC entry 3022 (class 2606 OID 17460)
-- Name: system_employees fk3f73dupygeal2ta695r920j7b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employees
    ADD CONSTRAINT fk3f73dupygeal2ta695r920j7b FOREIGN KEY (id) REFERENCES public.users(id);


--
-- TOC entry 3016 (class 2606 OID 17430)
-- Name: job_seekers fk6n38u8vdenycx0vm27sqy2jqn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT fk6n38u8vdenycx0vm27sqy2jqn FOREIGN KEY (id) REFERENCES public.users(id);


--
-- TOC entry 3013 (class 2606 OID 17420)
-- Name: job_advertisements fk8a1w1pinuwwa4280vy2cnnyal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT fk8a1w1pinuwwa4280vy2cnnyal FOREIGN KEY (user_id) REFERENCES public.employers(id);


--
-- TOC entry 3007 (class 2606 OID 17390)
-- Name: email_confirms_to_employer fkb8u2ngok1fkfytta3d9rrf89c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_confirms_to_employer
    ADD CONSTRAINT fkb8u2ngok1fkfytta3d9rrf89c FOREIGN KEY (employer_id) REFERENCES public.employers(id);


--
-- TOC entry 3017 (class 2606 OID 17435)
-- Name: languages fkblypoc2f194ie5qp2ryi0kh4o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT fkblypoc2f194ie5qp2ryi0kh4o FOREIGN KEY (curriculum_vitae_id) REFERENCES public.curriculum_vitaes(id);


--
-- TOC entry 3020 (class 2606 OID 17450)
-- Name: system_employee_confirms_to_employer fkc0a1goyvhrtcokuptpwbtmwm6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employee_confirms_to_employer
    ADD CONSTRAINT fkc0a1goyvhrtcokuptpwbtmwm6 FOREIGN KEY (employer_id) REFERENCES public.employers(id);


--
-- TOC entry 3010 (class 2606 OID 17405)
-- Name: email_confirms_to_job_seeker fkgmoopx13t2te81i1wpwf51ocn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_confirms_to_job_seeker
    ADD CONSTRAINT fkgmoopx13t2te81i1wpwf51ocn FOREIGN KEY (id) REFERENCES public.email_confirms(id);


--
-- TOC entry 3012 (class 2606 OID 17415)
-- Name: job_advertisements fkgnyxsalughgsumyjfb3bmr3jt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT fkgnyxsalughgsumyjfb3bmr3jt FOREIGN KEY (city_id) REFERENCES public.cities(city_id);


--
-- TOC entry 3024 (class 2606 OID 17470)
-- Name: work_experiences fkgsyyyfx5vmmviewkk6wc2gptn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work_experiences
    ADD CONSTRAINT fkgsyyyfx5vmmviewkk6wc2gptn FOREIGN KEY (curriculum_vitae_id) REFERENCES public.curriculum_vitaes(id);


--
-- TOC entry 3021 (class 2606 OID 17455)
-- Name: system_employee_confirms_to_employer fkh9serru15vvfeffefpds09d11; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employee_confirms_to_employer
    ADD CONSTRAINT fkh9serru15vvfeffefpds09d11 FOREIGN KEY (id) REFERENCES public.system_employee_confirms(id);


--
-- TOC entry 3014 (class 2606 OID 17425)
-- Name: job_advertisements fkhleljqy0g5lted8qo23w95mtl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT fkhleljqy0g5lted8qo23w95mtl FOREIGN KEY (position_id) REFERENCES public.positions(id);


--
-- TOC entry 3006 (class 2606 OID 17385)
-- Name: email_confirms fkknp2149v26cbxb99348utrfo2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_confirms
    ADD CONSTRAINT fkknp2149v26cbxb99348utrfo2 FOREIGN KEY (id) REFERENCES public.confirms(id);


--
-- TOC entry 3019 (class 2606 OID 17445)
-- Name: system_employee_confirms fkmmsdhc87rcu4p10g3r7gqs5ix; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_employee_confirms
    ADD CONSTRAINT fkmmsdhc87rcu4p10g3r7gqs5ix FOREIGN KEY (id) REFERENCES public.confirms(id);


--
-- TOC entry 3011 (class 2606 OID 17410)
-- Name: employers fknnl4ba0tc831e25ufip4ek2yq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT fknnl4ba0tc831e25ufip4ek2yq FOREIGN KEY (id) REFERENCES public.users(id);


--
-- TOC entry 3008 (class 2606 OID 17395)
-- Name: email_confirms_to_employer fkpcj0c4gtn9lfjl2uibwqh3uuw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_confirms_to_employer
    ADD CONSTRAINT fkpcj0c4gtn9lfjl2uibwqh3uuw FOREIGN KEY (id) REFERENCES public.email_confirms(id);


--
-- TOC entry 3018 (class 2606 OID 17440)
-- Name: schools fkrhd3eyb1tobb8wis5dlrkmx5v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schools
    ADD CONSTRAINT fkrhd3eyb1tobb8wis5dlrkmx5v FOREIGN KEY (curriculum_vitae_id) REFERENCES public.curriculum_vitaes(id);


-- Completed on 2021-06-03 18:16:12

--
-- PostgreSQL database dump complete
--

