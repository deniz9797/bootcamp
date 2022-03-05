--film tablosunda film uzunluğu length sütununda gösterilmektedir. Uzunluğu ortalama film uzunluğundan fazla kaç tane film vardır?
select count(*) from film where length > (select avg(length) from film);

--film tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?
select count(*) from film where rental_rate=(select max(rental_rate) from film);

--film tablosunda en düşük rental_rate ve en düşün replacement_cost değerlerine sahip filmleri sıralayınız.
select * from film where rental_rate=(select min(rental_rate) from film) and replacement_cost=(select min(replacement_cost) from film);

--payment tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.
--spesifik olarak belirtilmediği için en çok alışveriş yapan 10 müşteriyi sıraladım.
select sum(amount), customer.first_name, customer.last_name 
from payment 
join customer on customer.customer_id=payment.customer_id 
group by payment.customer_id, customer.first_name, customer.last_name 
order by sum(amount) desc limit 10;
