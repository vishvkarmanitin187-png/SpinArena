let balance = 0.72;

function updateBalanceUI() {
    document.getElementById('userBalance').innerText = balance.toFixed(2);
}

function openWallet() {
    document.getElementById('walletModal').classList.remove('hidden');
}

function closeWallet() {
    document.getElementById('walletModal').classList.add('hidden');
}

function makeDeposit() {
    const amt = parseFloat(document.getElementById('depositAmount').value);
    if (isNaN(amt) || amt <= 0) {
        alert('Kripya sahi amount enter karein!');
        return;
    }
    balance += amt;
    updateBalanceUI();
    alert(`Successfully deposited ₹${amt} via UPI (8819920722@naviaxis)!`);
    closeWallet();
}

function claimSignInBonus() {
    const btn = document.getElementById('signInBtn');
    const txt = document.getElementById('signInText');
    
    // Random bonus between ₹2 and ₹90
    const randomBonus = Math.floor(Math.random() * (90 - 2 + 1)) + 2;
    balance += randomBonus;
    updateBalanceUI();

    txt.innerText = `You won ₹${randomBonus}!`;
    btn.innerText = 'Claimed';
    btn.disabled = true;
    btn.classList.add('opacity-50', 'cursor-not-allowed');
}

function redeemCode() {
    const code = document.getElementById('promoInput').value.trim().toUpperCase();
    const msgBox = document.getElementById('redeemMsg');
    
    msgBox.classList.remove('hidden');

    if (code === 'WELCOME50' || code === 'SPIN90') {
        balance += 50;
        updateBalanceUI();
        msgBox.className = 'text-xs p-2 rounded-xl bg-emerald-500/20 border border-emerald-500/40 text-emerald-300';
        msgBox.innerText = 'Badhai ho! ₹50 aapke wallet mein add kar diye gaye hain.';
    } else {
        msgBox.className = 'text-xs p-2 rounded-xl bg-red-500/20 border border-red-500/40 text-red-300';
        msgBox.innerText = 'Galat ya expired promo code hai!';
    }
    document.getElementById('promoInput').value = '';
}
