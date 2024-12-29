SELECT
    DATE_FORMAT(t.trans_date, '%Y-%m') AS month,
    t.country,
    count(*) AS trans_count,
    COALESCE(approved_count, 0) as approved_count,
    sum(amount) AS trans_total_amount,
    COALESCE(sb.approved_total_amount, 0) as approved_total_amount

FROM
    transactions t
    LEFT JOIN
    (
    SELECT country, count(*) as approved_count, sum(amount) as approved_total_amount, DATE_FORMAT(trans_date, '%Y-%m') AS month
    FROM
    transactions
    WHERE
    state = 'approved'
    group by
    month, country
    ) as sb
ON
    DATE_FORMAT(t.trans_date, '%Y-%m') = sb.month AND (t.country = sb.country OR t.country is null AND sb.country is null)
GROUP BY
    DATE_FORMAT(t.trans_date, '%Y-%m'), t.country
