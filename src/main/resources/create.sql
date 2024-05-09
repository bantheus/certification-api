INSERT INTO questions (id, description, technology) VALUES
('8a53c416-c77f-410a-82e4-b79c1d633320', 'Como criar uma classe em Java?', 'JAVA'),
('8a53c416-c77f-410a-82e4-b79c1d633321', 'Explique o conceito de polimorfismo em Java', 'JAVA'),
('8a53c416-c77f-410a-82e4-b79c1d633322', 'Como lidar com exceções em Java?', 'JAVA');

INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('8a53c416-c77f-410a-82e4-b79c1d633323', '8a53c416-c77f-410a-82e4-b79c1d633320', true, 'public class MyClass {}'),
('8a53c416-c77f-410a-82e4-b79c1d633324', '8a53c416-c77f-410a-82e4-b79c1d633320', false, 'public MyClass {}'),
('8a53c416-c77f-410a-82e4-b79c1d633325', '8a53c416-c77f-410a-82e4-b79c1d633320', false, 'class MyClass {}'),

('8a53c416-c77f-410a-82e4-b79c1d633326', '8a53c416-c77f-410a-82e4-b79c1d633321', true, 'Capacidade de um objeto de ser referenciado de várias formas'),
('8a53c416-c77f-410a-82e4-b79c1d633327', '8a53c416-c77f-410a-82e4-b79c1d633321', false, 'Capacidade de um objeto de ser referenciado de uma única forma'),
('8a53c416-c77f-410a-82e4-b79c1d633328', '8a53c416-c77f-410a-82e4-b79c1d633321', false, 'Capacidade de um objeto de ser referenciado de nenhuma forma'),

('8a53c416-c77f-410a-82e4-b79c1d633329', '8a53c416-c77f-410a-82e4-b79c1d633322', true, 'try { ... } catch (Exception e) { ... }'),
('8a53c416-c77f-410a-82e4-b79c1d633330', '8a53c416-c77f-410a-82e4-b79c1d633322', false, 'try { ... } finally { ... }'),
('8a53c416-c77f-410a-82e4-b79c1d633331', '8a53c416-c77f-410a-82e4-b79c1d633322', false, 'try { ... } catch (Exception e) { ... } finally { ... }');
