-- Companies
INSERT INTO crm.companies (name, industry, website) VALUES
    ('Acme Corp',          'Manufacturing',        'https://acmecorp.com'),
    ('TechNova Solutions', 'Software',             'https://technova.io'),
    ('Greenleaf Energy',   'Energy',               'https://greenleaf.energy'),
    ('Westbrook Finance',  'Financial Services',   'https://westbrookfinance.com'),
    ('Orion Logistics',    'Transportation',       'https://orionlogistics.net'),
    ('BlueSky Media',      'Marketing',            'https://blueskymedia.co'),
    ('Nexus Health',       'Healthcare',           'https://nexushealth.org');

-- Contacts (referencing company IDs 1-7)
INSERT INTO crm.contacts (first_name, last_name, email, phone, company_id) VALUES
    ('Laura',   'Martínez',  'laura.martinez@acmecorp.com',         '+54 11 2345-6789', 1),
    ('Carlos',  'Gómez',     'carlos.gomez@acmecorp.com',           '+54 11 2345-6790', 1),
    ('Sophie',  'Wright',    'sophie.wright@technova.io',           '+1 415 555-0101',  2),
    ('Daniel',  'Chen',      'daniel.chen@technova.io',             '+1 415 555-0102',  2),
    ('Amira',   'Hassan',    'amira.hassan@greenleaf.energy',       '+20 2 2578-1234',  3),
    ('Roberto', 'Fernández', 'roberto.fernandez@westbrookfinance.com', '+54 351 456-7890', 4),
    ('Priya',   'Nair',      'priya.nair@orionlogistics.net',       '+91 98765-43210',  5),
    ('Tom',     'Brauer',    'tom.brauer@blueskymedia.co',          '+49 30 12345678',  6),
    ('Elena',   'Sousa',     'elena.sousa@nexushealth.org',         '+55 11 91234-5678', 7),
    ('Martina', 'López',     'martina.lopez@greenleaf.energy',      '+34 91 234 56 78', 3);

-- Leads
INSERT INTO crm.leads (first_name, last_name, email, phone, company_name, source, status, notes) VALUES
    ('Juan',     'Pérez',      'juan.perez@startup.io',        '+54 11 9876-5432', 'Startup IO',         'Website',    'NEW',       'Interested in the enterprise plan'),
    ('Maria',    'Silva',      'maria.silva@brasiltech.com',   '+55 21 98765-4321','Brasil Tech',        'LinkedIn',   'CONTACTED', 'Spoke on 2026-04-10, follow up next week'),
    ('Kevin',    'O''Brien',   'kevin.obrien@dublinsoft.ie',   '+353 1 555-0199',  'Dublin Soft',        'Referral',   'QUALIFIED', 'Needs demo scheduled, budget confirmed'),
    ('Fatima',   'Al-Amin',    'fatima.alamin@gulfretail.ae',  '+971 50 123 4567', 'Gulf Retail',        'Cold Email', 'NEW',       NULL),
    ('Lucas',    'Dupont',     'lucas.dupont@parisventures.fr','+33 6 12 34 56 78','Paris Ventures',     'Conference', 'CONTACTED', 'Met at TechSummit Paris 2026'),
    ('Yuki',     'Tanaka',     'yuki.tanaka@tokyodev.jp',      '+81 90-1234-5678', 'Tokyo Dev',          'Website',    'CONVERTED', 'Signed contract 2026-03-15'),
    ('Andrés',   'Castillo',   'andres.castillo@bogotacrm.co', '+57 310 987 6543', 'Bogotá CRM',         'LinkedIn',   'NEW',       'Reached out after webinar'),
    ('Nadia',    'Kowalski',   'nadia.kowalski@warsawit.pl',   '+48 600 123 456',  'Warsaw IT',          'Referral',   'QUALIFIED', 'Referred by TechNova Solutions'),
    ('Ethan',    'Brooks',     'ethan.brooks@sfanalytics.com', '+1 628 555-0133',  'SF Analytics',       'Website',    'CONTACTED', 'Downloaded whitepaper on 2026-04-28'),
    ('Ines',     'Moreau',     'ines.moreau@lyonhealth.fr',    '+33 4 78 90 12 34','Lyon Health',        'Cold Email', 'NEW',       NULL);
