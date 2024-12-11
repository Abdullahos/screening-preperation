-- u have gatways with ids and has firewal ref
-- also u have firewals with no of rules
-- print gatways id along with tot ruls for firewall for gatways with more than 1 firewall

SELECT
    g.gateway_id,
    SUM(f.rule_count) AS total_rules
FROM
    gateways g
        JOIN
    firewalls f ON g.firewalls_id = f.id
GROUP BY
    g.gateway_id
HAVING
    COUNT(g.gateway_id) > 1
   AND SUM(f.rule_count) >= 100;