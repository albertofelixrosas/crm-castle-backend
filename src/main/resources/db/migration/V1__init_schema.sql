CREATE SCHEMA IF NOT EXISTS crm;

CREATE TABLE IF NOT EXISTS crm.companies (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(140) NOT NULL UNIQUE,
    industry VARCHAR(80),
    website VARCHAR(180),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS crm.leads (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    email VARCHAR(120) NOT NULL,
    phone VARCHAR(40),
    company_name VARCHAR(120) NOT NULL,
    source VARCHAR(60),
    status VARCHAR(20) NOT NULL,
    notes TEXT,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS crm.contacts (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    phone VARCHAR(40),
    company_id BIGINT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_contacts_company FOREIGN KEY (company_id) REFERENCES crm.companies(id)
);

CREATE INDEX IF NOT EXISTS idx_leads_status ON crm.leads(status);
CREATE INDEX IF NOT EXISTS idx_leads_created_at ON crm.leads(created_at DESC);
CREATE INDEX IF NOT EXISTS idx_contacts_created_at ON crm.contacts(created_at DESC);
CREATE INDEX IF NOT EXISTS idx_companies_created_at ON crm.companies(created_at DESC);
