-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT FROM fish_info
WHERE fish_type IN (SELECT fish_type 
                    FROM fish_name_info
                    WHERE fish_name IN ('BASS', 'SNAPPER'));