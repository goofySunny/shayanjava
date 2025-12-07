CREATE SEQUENCE IF NOT EXISTS public.projects_seq start 99 increment 2;

CREATE TABLE IF NOT EXISTS public.projects (
    id int8 PRIMARY KEY DEFAULT nextval('public.projects_seq'),
    title VARCHAR(100) NOT NULL,
    project_description TEXT NOT NULL,
    image_name VARCHAR(255) 
);