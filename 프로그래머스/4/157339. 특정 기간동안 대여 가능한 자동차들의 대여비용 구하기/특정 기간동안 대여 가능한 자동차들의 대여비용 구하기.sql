-- 코드를 입력하세요
-- 1. 첫 테이블에서 CAR_TYPE = 'SUV' OR '세단' 인 car id만 고르기 
-- 2. 두 번째 테이블에서 history start_date end_date 에 11/1 ~ 11/30이 포함되어 있는 car_id 는 걸러야함 
-- 3. 마지막 테이블에서 cartype과 duration type='30일 이상' 을 만족해야하고 discount_rate를 뽑아서 daily_fee*30 * (1-discount_rate)한게 50만원 이상 200 미만인지 확인해야함 

SELECT
  C.CAR_ID,
  C.CAR_TYPE,
  FLOOR(C.DAILY_FEE * 30 * (1 - D.DISCOUNT_RATE / 100.0)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS C
-- 1) 할인 정책 조인 (30일 이상)
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS D
  ON C.CAR_TYPE = D.CAR_TYPE
  AND D.DURATION_TYPE = '30일 이상'
-- 2) 11월에 겹치는 이력 있는 차량 제외
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
  ON C.CAR_ID = H.CAR_ID
  AND H.START_DATE <= '2022-11-30'
  AND H.END_DATE   >= '2022-11-01'
WHERE
  C.CAR_TYPE IN ('세단', 'SUV')
  AND H.CAR_ID IS NULL
  -- 3) 30일 요금이 500,000 이상, 2,000,000 미만
  AND C.DAILY_FEE * 30 * (1 - D.DISCOUNT_RATE / 100.0) >= 500000
  AND C.DAILY_FEE * 30 * (1 - D.DISCOUNT_RATE / 100.0) <  2000000
ORDER BY
  FEE       DESC,
  C.CAR_TYPE ASC,
  C.CAR_ID   DESC;