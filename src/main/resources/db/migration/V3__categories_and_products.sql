CREATE SEQUENCE public.categories_seq START 69 INCREMENT 1;
CREATE SEQUENCE public.products_seq START 205 INCREMENT 1;

CREATE TABLE IF NOT EXISTS public.categories (
    id int8 PRIMARY KEY DEFAULT nextval('public.categories_seq'),
    cat_name VARCHAR(100) NOT NULL,
    image_name TEXT
);

CREATE TABLE IF NOT EXISTS public.products (
    id int8 PRIMARY KEY DEFAULT nextval('public.products_seq'),
    category_id int8 NOT NULL,
    product_name VARCHAR(150) NOT NULL,
    description TEXT,
    price BIGINT NOT NULL,
    image_name TEXT,
    is_showcased BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_category
        FOREIGN KEY(category_id) 
            REFERENCES public.categories(id)
            ON DELETE CASCADE
);