fn main() {
    println!("Largest palindrome: {}", get_largest_palindrome(100, 999));
}

fn get_largest_palindrome(min: i32, max: i32) -> i32 {
    let mut max_palindrome = 1;

    for first_num in min..=max {
        for second_num in min..=max {
            let product = first_num * second_num;

            if is_palindrome(product) {
                if max_palindrome < product {
                    max_palindrome = product;
                }
            }
        }
    }

    return max_palindrome;
}

fn is_palindrome(num: i32) -> bool {
    let num = num.to_string();
    let count = num.len();

    if is_even(count) {
        return false;
    }
    let half_count = count / 2;

    let first_half = num.chars().take(half_count);
    let second_half = num.chars().rev().take(half_count);

    return first_half.eq(second_half);
}

fn is_even(num: usize) -> bool {
    return num % 2 != 0;
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_palindrome() {
        assert!(is_palindrome(9009));
    }

    #[test]
    fn test_is_not_palindrome() {
        assert!(!is_palindrome(900));
    }

    #[test]
    fn largest_palindrome_99() {
        assert_eq!(get_largest_palindrome(10, 99), 9009);
    }

    #[test]
    fn largest_palindrome_999() {
        assert_eq!(get_largest_palindrome(100, 999), 906609);
    }
}