fn main() {
    println!("Largest prime factor: {}", get_largest_prime_factor(600851475143));
}

fn get_largest_prime_factor(number_to_check: i64) -> i64 {
    let max_factor_to_check = get_max_factor_to_check(number_to_check);

    let mut max_factor = 0;
    let mut number = number_to_check;

    for factor in 2..max_factor_to_check {
        if number % factor == 0 {
            number = number / factor;
            max_factor = factor;
        }

        if number == 1 {
            break;
        }
    }

    return max_factor;
}

fn get_max_factor_to_check(number: i64) -> i64 {
    return (number as f64).sqrt() as i64 + 1;
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn max_prime_factor_of_13195_is_29() {
        assert_eq!(get_largest_prime_factor(13195), 29);
    }

    #[test]
    fn max_prime_factor_of_600851475143_is_6857() {
        assert_eq!(get_largest_prime_factor(600851475143), 6857);
    }
}