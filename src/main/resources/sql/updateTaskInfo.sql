UPDATE mst_task_list
SET
    user_id = ?,
    task_name = ?,
    task_contents = ?,
    task_deadline = STR_TO_DATE(NULLIF(?, ''), '%Y-%m-%d'),
    task_status = ?,
    task_priority = ?,
    task_assignee = ?
WHERE
    task_id = ?;