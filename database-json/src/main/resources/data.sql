-- noinspection SqlResolveForFile

INSERT INTO json_table (id, json_field) VALUES (100, '{"intField": 10, "stringField": "String 1"}'::json);

INSERT INTO json_ident_data_table(id, ident, value) VALUES (100, '{"a": 1, "b": 2}'::json, 'Value1');
INSERT INTO json_ident_data_table(id, ident, value) VALUES (101, '{"a": 1, "c": 2}'::json, 'Value2');
INSERT INTO json_ident_data_table(id, ident, value) VALUES (102, '{"b": 1, "c": 2}'::json, 'Value3');