INSERT INTO parents (id, content) VALUES
(1, 'parent 1'),
(2, 'parent 2');

INSERT INTO children (parent_id, additional_id, content) VALUES
(1, 1, 'child 1-1'),
(1, 2, 'child 1-2'),
(1, 3, 'child 1-3'),
(2, 1, 'child 2-1'),
(2, 2, 'child 2-2');