SELECT COUNT(*) AS fish_count
FROM fish_info AS info
JOIN fish_name_info AS name
ON info.fish_type = name.fish_type
WHERE name.fish_name IN ('BASS', 'SNAPPER');
