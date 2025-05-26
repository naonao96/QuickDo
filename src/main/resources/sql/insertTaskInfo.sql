INSERT INTO mst_task_list (
    user_id,
    task_name,
    task_contents,
    task_deadline,
    task_status,
    task_priority,
    task_assignee
) VALUES (
    ?,
    ?,
    ?,
    STR_TO_DATE(?, '%Y-%m-%d'),
    ?,
    ?,
    ?
);