fn main() {
    const MAX_NUMBER: i32 = 1000;

    let sum = calculate_sum(MAX_NUMBER);

    println!("Sum: {}", sum);
}

fn calculate_sum(max_number: i32) -> i32 {
    let mut sum = 0;

    for num in 1..max_number {
        if is_multiple_3_or_5(num) {
            sum = sum + num;
        }
    }

    return sum
}

fn is_multiple_3_or_5(num: i32) -> bool {
    return num % 3 == 0 || num % 5 == 0;
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn sum_of_10_is_23() {
        assert_eq!(calculate_sum(10), 23);
    }

    #[test]
    fn sum_of_1000_is_233168() {
        assert_eq!(calculate_sum(1000), 233168);
    }
}